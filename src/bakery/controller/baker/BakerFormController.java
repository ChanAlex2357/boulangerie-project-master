package bakery.controller.baker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import bakery.model.Baker;
import bakery.model.Product;
import bakery.model.ProductType;
import bakery.model.Unit;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "BakerFormController", urlPatterns = "/bakerform")
public class BakerFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Utilitaire.getLayoutDispatcher(req, "insertion/baker-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }


}
