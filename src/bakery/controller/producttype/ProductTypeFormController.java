package bakery.controller.producttype;

import java.io.IOException;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductTypeForm", urlPatterns = "/producttypeform")
public class ProductTypeFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilitaire.getLayoutDispatcher(req, "insertion/producttype-form").forward(req, resp);
    }
}
