package bakery.data;

import java.sql.Connection;

import bakery.model.NatureType;

public class NatureTypeData {
    public void generate(Connection conn) throws Exception {
        NatureType[] natureTypes = new NatureType().getAll(conn);
        if (natureTypes.length > 0) {
            for (NatureType natureType : natureTypes) {
                System.out.println(natureType);
            }
            System.out.println("NatureType Already Exists ... ");
            return;
        }
        NatureType base = new NatureType("base", "Ingrédient de base");
        NatureType nonBase = new NatureType("non base", "Non ingrédient de base");

        base.save(conn);
        nonBase.save(conn);
    }
}
