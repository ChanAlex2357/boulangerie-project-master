package bakery.controller.recipe;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Ingredient;
import bakery.model.NatureType;
import bakery.model.Product;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RecipeForm", urlPatterns = "/recipeform")
public class RecipeFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            NatureType[] natureTypes = new NatureType().getAll(conn);
            Product[] products = new Product().getAll(conn);
            Ingredient[] ingredients = new Ingredient().getAll(conn);
            req.setAttribute("natureTypes", natureTypes);
            req.setAttribute("products", products);
            req.setAttribute("ingredients", ingredients);
            Utilitaire.getLayoutDispatcher(req, "insertion/recipe-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
