package bakery.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import bakery.model.ProductRecommendation;
import bakery.model.ProductRecommendationCpl;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductRecommendationController", urlPatterns = {"/productrecommendations"})
public class ProductRecommendationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
                listRecommendations(req, conn);
                Utilitaire.getLayoutDispatcher(req, "liste/product-recommendation-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            saveRecommendation(req, conn);
            resp.sendRedirect("/boulangerie/productrecommendations");
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    private void listRecommendations(HttpServletRequest req, Connection conn) throws Exception {
        // ProductRecommendation[] recommendations = new ProductRecommendation().getAll(conn);
        List<ProductRecommendationCpl> liste = ProductRecommendationCpl.getAllInstances(conn);
        req.setAttribute("recommendations", liste.toArray(new ProductRecommendationCpl[0]));
    }
    private void saveRecommendation(HttpServletRequest req, Connection conn) throws Exception {
        String productId = req.getParameter("productId");
        Date dateMin = Date.valueOf(req.getParameter("dateMin"));
        Date dateMax = Date.valueOf(req.getParameter("dateMax"));

        ProductRecommendation recommendation = new ProductRecommendation(productId, dateMin, dateMax);
        recommendation.save(conn);
    }
}

