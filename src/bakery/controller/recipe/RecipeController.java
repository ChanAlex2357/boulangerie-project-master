package bakery.controller.recipe;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Recipe;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RecipeList", urlPatterns = "/recipes")
public class RecipeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Recipe[] recipes = new Recipe().getAll(conn);
            req.setAttribute("recipes", recipes);
            Utilitaire.getLayoutDispatcher(req, "liste/recipe-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
