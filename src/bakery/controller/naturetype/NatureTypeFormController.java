package bakery.controller.naturetype;

import java.io.IOException;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "NatureTypeForm", urlPatterns = "/naturetypeform")
public class NatureTypeFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilitaire.getLayoutDispatcher(req, "insertion/naturetype-form").forward(req, resp);
    }
}
