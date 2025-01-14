package bakery.controller.product;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.jca.gfja.utils.DbUtils;

public class ProductController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        try (Connection conn = new DbUtils().getConn()) {
            Product[] products = new Product().getAll(conn);
            req.setAttribute("products", products);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String name = req.getParameter("name");
        String description = req.getParameter("descritpion");
        String isPurchase = req.getParameter("isPurchase");
        String isSale = req.getParameter("isPurchase");
        String purchase = req.getParameter("purchasePrice");
        String sale = req.getParameter("salePrice");
        String unitId = req.getParameter("unitId");
        String typeId = req.getParameter("productTypeId");

        try {
            Product product = new Product(name, description, isPurchase, isSale, purchase, sale, unitId, typeId);
            
            resp.getWriter().println(product);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
