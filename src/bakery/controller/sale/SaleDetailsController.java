package bakery.controller.sale;

import java.io.IOException;
import java.sql.Connection;

import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="VenteDetailsController",urlPatterns = "/saledetails")
public class SaleDetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(Connection conn = Utilitaire.getConn()){
            Utilitaire.getLayoutDispatcher(req,"liste/saledetails");
        }catch(Exception e) {
            e.printStackTrace(resp.getWriter());
        }
        req.getRequestDispatcher("pages/layout.jsp?page=vente-details.jsp").forward(req, resp);
    }
}
