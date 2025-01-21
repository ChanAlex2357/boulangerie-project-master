package bakery.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;
import mg.jca.gfja.utils.GenUtils;

@Entity
public class Customer extends ClassMap {

    @Id(procedure = "GET_CUSTOMER_SEQ", seq = "CUS")
    String id;
    String name;
    String phone;
    String address;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Customer() {}

    public Customer(String name, String phone, String address) {
        setName(name);
        setPhone(phone);
        setAddress(address);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer[] filter(String dmin, String dmax, Connection conn) throws Exception {
        if((dmin==null || dmin.equals("")) && (dmax==null || dmax.equals(""))) {
            return getAll(conn);
        }
        List<Customer>  customers = new ArrayList<>();
        String query = "SELECT distinct customer_id,customer_name,customer_phone,customer_address FROM CustomersSale WHERE 1=1 ";
        if((dmin!=null || !dmin.equals("")) && (dmax==null || dmax.equals(""))) {
            dmax=dmin;
        }
        if((dmin==null || dmin.equals("")) && (dmax!=null || !dmax.equals(""))) {
            dmin=dmax;
        }
        query+="and (sale_date between '"+dmin+"' and '"+dmax+"')";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setId(rs.getString("customer_id"));
                    customer.setName(rs.getString("customer_name"));
                    customer.setPhone(rs.getString("customer_phone"));
                    customer.setAddress(rs.getString("customer_address"));
                    customers.add(customer);
                }
            }
        }
        System.out.println(customers.size());
        return customers.toArray(new Customer[0]);
    }
}
