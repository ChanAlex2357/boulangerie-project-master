package bakery.controller.baker;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.BakerCommissionLib;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "BakerFormController", urlPatterns = "/BakerCommissionLibs")
public class BakerCommissionListController extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            String dmin=req.getParameter("dmin");;
            String dmax=req.getParameter("dmax");;
            BakerCommissionLib[] bakerCommissionLibs = new BakerCommissionLib().filter(dmin,dmax,conn);
            req.setAttribute("bakerCommissionLibs", bakerCommissionLibs);
            Utilitaire.getLayoutDispatcher(req, "liste/baker-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
