package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity(name = "ProductType")
    
public class ProductType extends ClassMap {

    @Id(procedure = "GET_", seq = "")
    public String id;
    public String value;
    public String description;

    @Override
    public void controle(Connection arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'controle'");
    }
}

