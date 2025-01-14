package bakery.controller.ingredient;

import java.io.IOException;
import java.sql.Connection;
import bakery.model.IngredientType;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "IngredientTypeController", urlPatterns = "/ingredienttypes")
public class IngredientTypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            liste(req, conn);
            Utilitaire.getLayoutDispatcher(req, "liste/ingredienttype-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    private IngredientType[] liste(HttpServletRequest req, Connection conn) throws Exception {
        IngredientType[] ingredientTypes = new IngredientType().getAll(conn);
        req.setAttribute("ingredientTypes", ingredientTypes);
        return ingredientTypes;
    }
}
