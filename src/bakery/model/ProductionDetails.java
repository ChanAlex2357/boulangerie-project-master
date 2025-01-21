package bakery.model;

import java.sql.Connection;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class ProductionDetails extends ClassMap {

    @Id(procedure = "GET_PRODUCTIONDETAILS_SEQ", seq = "PDE")
    String id;
    @Attribute(name = "quantity")
    double quantity;
    @Attribute(name = "ingredient_id")
    String ingredientId;
    @Attribute(name = "production_id")
    String productionId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public ProductionDetails() {}

    public ProductionDetails(double quantity, String ingredientId, String productionId) {
        setQuantity(quantity);
        setIngredientId(ingredientId);
        setProductionId(productionId);
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }
}
