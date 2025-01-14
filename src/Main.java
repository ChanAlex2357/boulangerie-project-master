import java.sql.Connection;

import bakery.data.IngredientTypeData;
import bakery.util.Utilitaire;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Utilitaire.getConn()) {
            // new UnitData().generate(conn);
            // new ProductTypeData().generate(conn);
            // new NatureTypeData().generate(conn);
            // new ProductData().generate(conn);
            new IngredientTypeData().generate(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
