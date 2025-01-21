package bakery.controller.producttype;

import java.io.IOException;
import java.sql.Connection;
import bakery.model.ProductType;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductTypeController", urlPatterns = "/producttypes")
public class ProductTypeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try (Connection conn = Utilitaire.getConn()) {
            delete(req, action, conn);
            liste(req, conn);
            Utilitaire.getLayoutDispatcher(req, "liste/producttype-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String value = req.getParameter("value");
        String description = req.getParameter("description");

        ProductType productType = new ProductType(value, description);
        try (Connection conn = Utilitaire.getConn()) {
            try {
                conn.setAutoCommit(false);
                if (action.equals("modif")) {
                    // Modification
                } else {
                    productType.save(conn);
                }
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }

        resp.sendRedirect("/boulangerie/producttypes");
    }

    private ProductType delete(HttpServletRequest request, String action, Connection conn) {
        if (action != null && !action.equals("delete")) {
            return null;
        }
        String idProductType = request.getParameter("idproducttypes");
        ProductType productType = new ProductType();
        if (idProductType == null) {
            return null;
        }
        productType.setId(idProductType);
        return productType;
    }

    private ProductType[] liste(HttpServletRequest req, Connection conn) throws Exception {
        ProductType[] productTypes = new ProductType().getAll(conn);
        req.setAttribute("productTypes", productTypes);
        return productTypes;
    }
}
