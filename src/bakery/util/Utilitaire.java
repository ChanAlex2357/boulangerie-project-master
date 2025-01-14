package bakery.util;

import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import mg.jca.gfja.utils.DbUtils;

public class Utilitaire {
    public static DbUtils DbUtils(){
            try {
                Class.forName("org.postgresql.Driver");
                System.out.println("Loaded Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new DbUtils("jdbc:postgresql://localhost:5432/bakery","postgres","itu16");
        }

    public static Connection getConn(){
        return Utilitaire.DbUtils().getConn();
    }

    public static RequestDispatcher getLayoutDispatcher(HttpServletRequest request,String page){
        return request.getRequestDispatcher("layout.jsp?page=pages/"+page+".jsp");
    }
}
