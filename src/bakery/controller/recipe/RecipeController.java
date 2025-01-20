package bakery.controller.recipe;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Ingredient;
import bakery.model.NatureType;
import bakery.model.Product;
import bakery.model.Recipe;
import bakery.model.RecipeIngredient;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RecipeController", urlPatterns = "/recipes")
public class RecipeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        try (Connection conn = Utilitaire.getConn()) {
            if ("/recipes".equals(path)) {
                listRecipes(req, conn);
                Utilitaire.getLayoutDispatcher(req, "liste/recipe-list").forward(req, resp);
            } else if ("/recipeform".equals(path)) {
                showForm(req, conn);
                Utilitaire.getLayoutDispatcher(req, "insertion/recipe-form").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            saveRecipe(req, conn);
            resp.sendRedirect("/boulangerie/recipes");
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    private void listRecipes(HttpServletRequest req, Connection conn) throws Exception {
        Recipe[] recipes = new Recipe().getAll(conn);
        req.setAttribute("recipes", recipes);
    }

    private void showForm(HttpServletRequest req, Connection conn) throws Exception {
        NatureType[] natureTypes = new NatureType().getAll(conn);
        Product[] products = new Product().getAll(conn);
        Ingredient[] ingredients = new Ingredient().getAll(conn);
        req.setAttribute("natureTypes", natureTypes);
        req.setAttribute("products", products);
        req.setAttribute("ingredients", ingredients);
    }

    private void saveRecipe(HttpServletRequest req, Connection conn) throws Exception {
        String productId = req.getParameter("productId");
        String[] ingredientIds = req.getParameterValues("ingredientId[]");
        String[] quantities = req.getParameterValues("quantity[]");

        Recipe recipe = new Recipe();
        recipe.setProductId(productId);

        RecipeIngredient[] recipeIngredients = new RecipeIngredient[ingredientIds.length];
        for (int i = 0; i < ingredientIds.length; i++) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();
            recipeIngredient.setIngredientId(ingredientIds[i]);
            recipeIngredient.setQuantity(Double.parseDouble(quantities[i]));
            recipeIngredients[i] = recipeIngredient;
        }
        recipe.setRecipeIngredients(recipeIngredients);
        recipe.saveWithIngredients(conn);
    }
}
