package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Ingredient extends ClassMap {

    @Id(procedure = "GET_INGREDIENT_SEQ", seq = "ING")
    String id;
    String name;
    String description;
    double purchasePrice;
    @Attribute(name = "unit_id")
    String unitId;
    @Attribute(name = "ingredient_type_id")
    String ingredientTypeId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Ingredient() {}

    public Ingredient(String name, String description, String purchasePrice, String unitId, String ingredientTypeId) {
        setName(name);
        setDescription(description);
        setPurchasePrice(purchasePrice);
        setUnitId(unitId);
        setIngredientTypeId(ingredientTypeId);
    }

    public void setPurchasePrice(String value) {
        double doubleValue = Double.valueOf(value);
        setPurchasePrice(doubleValue);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getIngredientTypeId() {
        return ingredientTypeId;
    }

    public void setIngredientTypeId(String ingredientTypeId) {
        this.ingredientTypeId = ingredientTypeId;
    }
}
