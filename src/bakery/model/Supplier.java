package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Supplier extends ClassMap {

    @Id(procedure = "GET_SUPPLIER_SEQ", seq = "SUP")
    String id;
    String name;
    String location;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Supplier() {}

    public Supplier(String name, String location) {
        setName(name);
        setLocation(location);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
