package bakery.controller.ingredient;

import java.io.IOException;
import java.sql.Connection;

import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "IngredientTypeForm", urlPatterns = "/ingredienttypeform")
public class IngredientTypeFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Utilitaire.getLayoutDispatcher(req, "insertion/ingredienttype-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
