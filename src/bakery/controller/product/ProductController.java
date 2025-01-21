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

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try (Connection conn = Utilitaire.getConn()) {
            delete(req, action, conn);
            liste(req, conn);
            Utilitaire.getLayoutDispatcher(req, "liste/product-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String salePrice = req.getParameter("salePrice");
        String unitId = req.getParameter("unitId");
        String productTypeId = req.getParameter("productTypeId");

        Product product = new Product(name, description, salePrice, unitId, productTypeId);
        try (Connection conn = Utilitaire.getConn()) {
            try {
                conn.setAutoCommit(false);
                if (action.equals("modif")) {
                    // Modification
                } else {
                    product.save(conn);
                }
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }

        resp.sendRedirect("/boulangerie/products");
    }

    private Product delete(HttpServletRequest request, String action, Connection conn) {
        if (action != null && !action.equals("delete")) {
            return null;
        }
        String idProduct = request.getParameter("idproducts");
        Product product = new Product();
        if (idProduct == null) {
            return null;
        }
        product.setId(idProduct);
        return product;
    }

    private Product[] liste(HttpServletRequest req, Connection conn) throws Exception {
        Product[] products = new Product().getAll(conn);
        req.setAttribute("products", products);
        return products;
    }
}
