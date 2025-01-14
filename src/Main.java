import java.sql.Connection;

import bakery.data.ProductData;
import bakery.data.ProductTypeData;
import bakery.data.UnitData;
import bakery.data.NatureTypeData;
import bakery.data.IngredientTypeData;
import bakery.util.Utilitaire;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Utilitaire.getConn()) {
            new UnitData().generate(conn);
            new ProductTypeData().generate(conn);
            new NatureTypeData().generate(conn);
            new IngredientTypeData().generate(conn);
            new ProductData().generate(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
