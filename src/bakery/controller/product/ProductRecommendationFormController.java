package bakery.controller.product;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Product;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductRecommendationForm", urlPatterns = "/productrecommendationform")
public class ProductRecommendationFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Product[] products = new Product().getAll(conn);
            req.setAttribute("products", products);
            Utilitaire.getLayoutDispatcher(req, "insertion/product-recommendation-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
