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

@WebServlet(name="VenteDetailsController",urlPatterns = "/vente-details")
public class VenteDetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("pages/layout.jsp?page=vente-details.jsp").forward(req, resp);
    }
}
