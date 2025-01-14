package bakery.controller.ingredient;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Unit;
import bakery.model.IngredientType;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "IngredientForm", urlPatterns = "/ingredientform")
public class IngredientFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Unit[] units = new Unit().getAll(conn);
            IngredientType[] ingredientTypes = new IngredientType().getAll(conn);
            req.setAttribute("units", units);
            req.setAttribute("ingredientTypes", ingredientTypes);
            Utilitaire.getLayoutDispatcher(req, "insertion/ingredient-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
