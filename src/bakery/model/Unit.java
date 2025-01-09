package bakery.model;

import java.sql.Connection;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity(name = "Unit")
public class Unit extends ClassMap {

    @Id(procedure = "GET_UNIT_SEQ" , seq = "UNT")
    public String id;
    public String value;
    public String description;

    @Override
    public void controle(Connection arg0) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'controle'");
    }    
}