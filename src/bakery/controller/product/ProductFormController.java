package bakery.controller.product;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.ProductType;
import bakery.model.Unit;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.jca.gfja.utils.DbUtils;

public class ProductFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = new DbUtils().getConn();
        try {
            /// Recuperer la liste des donnee pour le formulaire
            Unit[] units = new Unit().getAll(conn);
            ProductType[] productTypes = new ProductType().getAll(conn);

            req.setAttribute("units", units);
            req.setAttribute("productTypes", productTypes);
            req.getRequestDispatcher("pages/product/product-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
