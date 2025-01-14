package bakery.controller.inventory;

import java.io.IOException;
import java.sql.Connection;
import bakery.model.Inventory;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "InventoryController", urlPatterns = "/inventories")
public class InventoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection conn = Utilitaire.getConn()) {
            liste(req, conn);
            Utilitaire.getLayoutDispatcher(req, "liste/inventory-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }

    private Inventory[] liste(HttpServletRequest req, Connection conn) throws Exception {
        Inventory[] inventories = new Inventory().getAll(conn);
        req.setAttribute("inventories", inventories);
        return inventories;
    }
}
