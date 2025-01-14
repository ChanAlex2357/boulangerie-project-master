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
    @Attribute(name = "recipe_cost")
    double recipeCost;
    String name;
    @Attribute(name = "nature_type_id")
    String natureTypeId;
    @Attribute(name = "product_id")
    String productId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Recipe() {}

    public Recipe(double recipeCost, String name, String natureTypeId, String productId) {
        setRecipeCost(recipeCost);
        setName(name);
        setNatureTypeId(natureTypeId);
        setProductId(productId);
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

    public String getNatureTypeId() {
        return natureTypeId;
    }

    public void setNatureTypeId(String natureTypeId) {
        this.natureTypeId = natureTypeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
