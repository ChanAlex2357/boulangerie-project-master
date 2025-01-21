package bakery.controller.product;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.ProductType;
import bakery.model.Unit;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductForm", urlPatterns = "/productform")
public class ProductFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Unit[] units = new Unit().getAll(conn);
            ProductType[] productTypes = new ProductType().getAll(conn);
            req.setAttribute("units", units);
            req.setAttribute("productTypes", productTypes);
            Utilitaire.getLayoutDispatcher(req, "insertion/product-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
