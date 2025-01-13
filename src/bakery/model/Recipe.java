package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Recipe extends ClassMap {

    @Id(procedure = "GET_RECIPE_SEQ", seq = "REC")
    String id;
    double recipeCost;
    String name;
    boolean isDerived;
    @Attribute(name = "product_id")
    String productId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Recipe() {}

    public Recipe(String recipeCost, String name, boolean isDerived, String productId) {
        setRecipeCost(recipeCost);
        setName(name);
        setDerived(isDerived);
        setProductId(productId);
    }

    public void setRecipeCost(String value) {
        double doubleValue = Double.valueOf(value);
        setRecipeCost(doubleValue);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRecipeCost() {
        return recipeCost;
    }

    public void setRecipeCost(double recipeCost) {
        this.recipeCost = recipeCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDerived() {
        return isDerived;
    }

    public void setDerived(boolean isDerived) {
        this.isDerived = isDerived;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
