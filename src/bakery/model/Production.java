package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Production extends ClassMap {

    @Id(procedure = "GET_PRODUCTION_SEQ", seq = "PROD")
    String id;
    @Attribute(name = "production_date")
    java.sql.Date productionDate;
    @Attribute(name = "production_cost")
    String productionCost;
    @Attribute(name = "product_id")
    String productId;
    @Attribute(name = "recipe_id")
    String recipeId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(java.sql.Date productionDate) {
        this.productionDate = productionDate;
    }

    public String getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(String productionCost) {
        this.productionCost = productionCost;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    @Override
    public void controle(Connection arg0) throws Exception {
         
    }
}
