package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class CustomerOrderDetails extends ClassMap {

    @Id(procedure = "GET_CUSTOMER_ORDER_DETAILS_SEQ", seq = "CUSTORDDET")
    String id;
    @Attribute(name = "quantity")
    double quantity;
    @Attribute(name = "unit_price")
    double unitPrice;
    @Attribute(name = "product_id")
    String productId;
    @Attribute(name = "order_id")
    String orderId;

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    // Getters and Setters
    // ...existing code...
}
