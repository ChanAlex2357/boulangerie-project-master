package bakery.data;

import java.sql.Connection;

import bakery.model.Unit;

public class UnitData implements DataGen{
    @Override
    public void generate(Connection conn) throws Exception {
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
        litre.setDescription("Litre");

        Unit metre = new Unit();
        metre.setValue("M");
        metre.setDescription("Metre");

        unit.save(conn);
        kg.save(conn);
        litre.save(conn);
        metre.save(conn);
    }
}
