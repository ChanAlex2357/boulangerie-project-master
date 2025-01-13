package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Sale extends ClassMap {

    @Id(procedure = "GET_SALE_SEQ", seq = "SAL")
    String id;
    @Attribute(name = "sale_date")
    Date saleDate;
    double amount;
    @Attribute(name = "customer_id")
    String customerId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Sale() {}

    public Sale(Date saleDate, double amount, String customerId) {
        setSaleDate(saleDate);
        setAmount(amount);
        setCustomerId(customerId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
