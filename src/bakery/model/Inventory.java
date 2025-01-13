package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Inventory extends ClassMap {

    @Id(procedure = "GET_INVENTORY_SEQ", seq = "INV")
    String id;
    @Attribute(name = "inventory_date")
    java.sql.Date inventoryDate;
    @Attribute(name = "theoretical_quantity")
    double theoreticalQuantity;
    @Attribute(name = "actual_quantity")
    double actualQuantity;
    @Attribute(name = "product_id")
    String productId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getInventoryDate() {
        return inventoryDate;
    }

    public void setInventoryDate(java.sql.Date inventoryDate) {
        this.inventoryDate = inventoryDate;
    }

    public double getTheoreticalQuantity() {
        return theoreticalQuantity;
    }

    public void setTheoreticalQuantity(double theoreticalQuantity) {
        this.theoreticalQuantity = theoreticalQuantity;
    }

    public double getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public void controle(Connection arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'controle'");
    }
}
