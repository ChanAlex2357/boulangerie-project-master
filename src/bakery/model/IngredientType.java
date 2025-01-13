package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class IngredientType extends ClassMap {

    @Id(procedure = "GET_INGREDIENT_TYPE_SEQ", seq = "INGT")
    String id;
    String value;
    String description;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public IngredientType() {}

    public IngredientType(String value, String description) {
        setValue(value);
        setDescription(description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
