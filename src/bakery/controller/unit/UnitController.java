package bakery.controller.unit;

import java.io.IOException;
import java.sql.Connection;

import bakery.model.Unit;
import bakery.util.Utilitaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "UnitController" , urlPatterns = "/units")
public class UnitController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try ( Connection conn = Utilitaire.getConn()) {
            delete(req, action, conn);
            liste(req, conn);
            Utilitaire.getLayoutDispatcher(req,"liste/unit-list").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        String val = req.getParameter("val");
        String desce = req.getParameter("description");
       
        Unit unit = new Unit(val, desce);
        try (Connection conn = Utilitaire.getConn()) {
            try {
                conn.setAutoCommit(false);

                if (action.equals("modif")) {
                    // Modification
                }
                else{unit.save(conn);}
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }

        resp.sendRedirect("/boulangerie/units");
    }
    
    private Unit delete(HttpServletRequest request , String action , Connection conn){
        if ( action != null && !action.equals("delete")) {
            return null; 
        }
        String idUnit = request.getParameter("idunits");
        Unit unit = new Unit();
        if (idUnit == null) {
            return null;
        }
        unit.setId(idUnit);
        return unit; 
    }
    private Unit[] liste(HttpServletRequest req , Connection conn) throws Exception{
        Unit[] units = new Unit().getAll(conn);
        req.setAttribute("units",units);
        return units;
    } 

}
