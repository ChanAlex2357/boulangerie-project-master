package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class SaleDetails extends ClassMap {

    @Id(procedure = "GET_SALE_DETAILS_SEQ", seq = "SALEDET")
    String id;
    @Attribute(name = "quantity")
    double quantity;
    @Attribute(name = "unit_price")
    double unitPrice;
    @Attribute(name = "recipe_id")
    String recipeId;
    @Attribute(name = "sale_id")
    String saleId;

    @Override
    public void controle(Connection arg0) throws Exception {}

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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    // Getters and Setters
    // ...existing code...
}
