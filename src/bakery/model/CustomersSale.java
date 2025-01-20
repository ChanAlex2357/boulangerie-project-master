package bakery.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class CustomersSale extends ClassMap {

    String saleId;
    String saleDate;
    double saleAmount;
    String customerId;
    String customerName;
    String customerPhone;
    String customerAddress;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public CustomersSale() {}

    public static List<CustomersSale> filter(Connection conn) throws Exception {
        List<CustomersSale> sales = new ArrayList<>();
        String query = "SELECT * FROM CustomersSale";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CustomersSale sale = new CustomersSale();
                sale.setSaleId(rs.getString("sale_id"));
                sale.setSaleDate(rs.getString("sale_date"));
                sale.setSaleAmount(rs.getDouble("sale_amount"));
                sale.setCustomerId(rs.getString("customer_id"));
                sale.setCustomerName(rs.getString("customer_name"));
                sale.setCustomerPhone(rs.getString("customer_phone"));
                sale.setCustomerAddress(rs.getString("customer_address"));
                sales.add(sale);
            }
        }
        return sales;
    }

    // Getters and Setters
    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
