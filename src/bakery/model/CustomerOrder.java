package bakery.model;

import java.sql.Connection;
import java.sql.Date;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class CustomerOrder extends ClassMap {

    @Id(procedure = "GET_CUSTOMER_ORDER_SEQ", seq = "CUSTORD")
    String id;
    @Attribute(name = "order_date")
    Date orderDate;
    @Attribute(name = "amount")
    double amount;
    @Attribute(name = "status_id")
    String statusId;
    @Attribute(name = "customer_id")
    String customerId;

    @Override
    public void controle(Connection arg0) throws Exception {}
    // Getters and Setters
    // ...existing code...

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
