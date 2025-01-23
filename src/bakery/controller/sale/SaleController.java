package bakery.controller.sale;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Sale;
import bakery.model.SaleDetails;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="SaleController",urlPatterns = "/sales")
public class SaleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            Sale[] sales = new Sale().getAll(conn);
            req.setAttribute("sales", sales);
            Utilitaire.getLayoutDispatcher(req, "liste/sale-list").forward(req, resp);;
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            saveSale(req, conn);
            resp.sendRedirect("/boulangerie/sales");
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    private void saveSale(HttpServletRequest req , Connection conn) throws Exception {
        conn.setAutoCommit(false);
        try {
            String date = req.getParameter("date");
            String customerId = req.getParameter("CustomerId");
            String bakerId = req.getParameter("BakerId");
            String [] products = req.getParameterValues("productId[]");
            String [] quantity = req.getParameterValues("quantity[]");
    
            Sale sale = new Sale();
            sale.setSaleDate(date);
            sale.setCustomerId(customerId);
            sale.setBakerId(bakerId);
    
            SaleDetails[] saleDetails = SaleDetails.generateSaleDetails(products, quantity, conn); 
            sale.setSaleDetails(saleDetails);
            sale.save(conn);
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
        }
    }

}