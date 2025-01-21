package bakery.controller.naturetype;

import java.io.IOException;
import java.sql.Connection;
import bakery.model.NatureType;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "NatureTypeController", urlPatterns = "/naturetypes")
public class NatureTypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            liste(req, conn);
            Utilitaire.getLayoutDispatcher(req, "liste/naturetype-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    private NatureType[] liste(HttpServletRequest req, Connection conn) throws Exception {
        NatureType[] natureTypes = new NatureType().getAll(conn);
        req.setAttribute("natureTypes", natureTypes);
        return natureTypes;
    }
}
