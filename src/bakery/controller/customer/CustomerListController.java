package bakery.controller.customer;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Customer;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.jca.gfja.utils.DbUtils;

@WebServlet(name="CustomerListController",urlPatterns = "/customers")
public class CustomerListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = new DbUtils().getConn();
        try {
            String dmin = req.getParameter("dmin");
            String dmax = req.getParameter("dmax");
            Customer[] customers = new Customer().filter(dmin , dmax,conn);
            req.setAttribute("customers", customers);
            Utilitaire.getLayoutDispatcher(req,"liste/customer-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
