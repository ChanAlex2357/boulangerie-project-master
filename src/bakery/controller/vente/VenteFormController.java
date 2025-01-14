package bakery.controller.vente;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.ProductType;
import bakery.model.Unit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.jca.gfja.utils.DbUtils;

@WebServlet(name="VenteFormController",urlPatterns = "/vente-form")
public class VenteFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = new DbUtils().getConn();
        try {
            /// Recuperer la liste des donnee pour le formulaire
            Customer[] customers = new Customer().getAll(conn);
            Product[] products = new Product().getAll(conn);
            req.setAttribute("customer", customers);
            req.setAttribute("product", products);
            req.getRequestDispatcher("pages/layout.jsp?page=vente-form.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
