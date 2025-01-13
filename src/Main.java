import java.sql.Connection;

import bakery.model.Product;
import mg.jca.gfja.utils.DbUtils;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = new DbUtils().getConn();) {
            Product[] products = new Product().getAll(conn);
            for (Product product : products) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
