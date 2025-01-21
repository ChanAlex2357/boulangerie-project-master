package bakery.controller.unit;

import java.io.IOException;

import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UnitForm" , urlPatterns = "/unitform")
public class UnitFormController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilitaire.getLayoutDispatcher(req,"insertion/unit-form").forward(req, resp);
    }
}
