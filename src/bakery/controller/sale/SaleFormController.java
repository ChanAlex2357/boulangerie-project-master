package bakery.controller.sale;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Baker;
import bakery.model.Customer;
import bakery.model.Product;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="SaleFormController",urlPatterns = "/saleform")
public class SaleFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Product[] products = new Product().getAll(conn);
            /// Recuperer la liste des donnee pour le formulaire
            Customer[] customers = new Customer().getAll(conn);
            Baker[] bakers = new Baker().getAll(conn);
            req.setAttribute("bakers", bakers);
            req.setAttribute("customers", customers);
            req.setAttribute("products", products);
            Utilitaire.getLayoutDispatcher(req,"insertion/sale-form").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
