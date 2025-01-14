package bakery.controller.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

import bakery.model.Customer;
import bakery.model.Product;
import bakery.model.ProductRecommandation;
import bakery.model.ProductRecommandationCpl;
import bakery.model.ProductType;
import bakery.model.Unit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mg.jca.gfja.utils.DbUtils;

@WebServlet(name="ProductRecommandationController",urlPatterns = "/recommandation-form")
public class ProductRecommandationController {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = new DbUtils().getConn();
        //recuperer les valeurs de filtre
        Date dateDebut=Date.valueOf(req.getParameter("dateDebut"));
        Date dateFin=Date.valueOf(req.getParameter("dateFin"));
        Double productPriceMin=Double.parseDouble(req.getParameter("priceMin"));
        Double productPriceMax=Double.parseDouble(req.getParameter("priceMax"));
        String typeValue=req.getParameter("typeValue");
        String recipeType=req.getParameter("recipeType");
        try {
            //recuperer les donnees dans les bases
            ProductRecommandationCpl[] productRecommCpl= new ProductRecommandationCpl().getAll(conn);
            req.setAttribute("productRecommandation", productRecommCpl);
            //envoyer la liste correspondante
            req.getRequestDispatcher("pages/layout.jsp?page=recommandation-form.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = new DbUtils().getConn();
        try {
            //Recuperer le produit inserer
            String idProduct=req.getParamater("idProduct");
            String dateDebut=req.getParamater("dateDebut");
            String dateFin=req.getParamater("dateFin");
            //Inserer le produit dans la base
            ProductRecommandation product=new ProductRecommandation(idProduct,dateDebut,dateFin);
            product.save(conn);
        } catch (Exception e) {
            e.printStackTrace(resp.getWriter());
        }
    }
}
