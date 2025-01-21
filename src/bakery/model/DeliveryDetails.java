package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class DeliveryDetails extends ClassMap {

    @Id(procedure = "GET_DELIVERY_DETAILS_SEQ", seq = "DELDET")
    String id;
    @Attribute(name = "quantity")
    double quantity;
    @Attribute(name = "product_id")
    String productId;
    @Attribute(name = "delivery_id")
    String deliveryId;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }


    // Getters and Setters
    // ...existing code...
}
