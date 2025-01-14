import java.sql.Connection;

import bakery.model.Unit;
import bakery.util.Utilitaire;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Utilitaire.getConn()) {
            generateUnitData(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateUnitData(Connection conn) throws Exception {
        Unit[] units = new Unit().getAll(conn); 
        if (units.length > 0) {
            for (Unit unit : units) {
                System.out.println(unit);
            }
            System.out.println("UNIT Already Exists ... ");
            return;
        }
        Unit unit = new Unit();
        unit.setValue("Unite");
        unit.setDescription("Simple Unite");

        Unit kg = new Unit();
        kg.setValue("Kg");
        kg.setDescription("Kilogramme");

        Unit litre = new Unit();
        litre.setValue("L");
        kg.setDescription("Litre");


        unit.save(conn);
        kg.save(conn);
        litre.save(conn);
    }
}
