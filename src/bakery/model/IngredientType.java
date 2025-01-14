package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class IngredientType extends ClassMap {

    @Id(procedure = "GET_INGREDIENT_TYPE_SEQ", seq = "INGT")
    String id;
    String value;
    String description;
    @Attribute(name = "nature_type_id")
    String natureTypeId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public IngredientType() {}

    public IngredientType(String value, String description, String natureTypeId) {
        setValue(value);
        setDescription(description);
        setNatureTypeId(natureTypeId);
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

    public String getNatureTypeId() {
        return natureTypeId;
    }

    public void setNatureTypeId(String natureTypeId) {
        this.natureTypeId = natureTypeId;
    }
}
