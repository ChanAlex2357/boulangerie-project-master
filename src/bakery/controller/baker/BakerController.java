package bakery.controller.baker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import bakery.model.Baker;
import bakery.model.Unit;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "BakerController" , urlPatterns = "/bakers")
public class BakerController extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Baker[] bakers = new Baker().getAll(conn);
            req.setAttribute("bakers", bakers);
            Utilitaire.getLayoutDispatcher(req, "liste/baker-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date dateEmbauche = Date.valueOf(req.getParameter("dateEmbauche"));
        double commission = Double.parseDouble(req.getParameter("commission"));
        Baker baker = new Baker(name,dateEmbauche,commission);
        try (Connection conn = Utilitaire.getConn()) {
            try {
                conn.setAutoCommit(false);
                baker.save(conn);
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }

        resp.sendRedirect("/boulangerie/bakers");
    }
}
