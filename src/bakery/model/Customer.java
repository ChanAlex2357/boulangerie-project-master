package bakery.model;

import java.sql.Connection;

import jakarta.servlet.http.HttpServletRequest;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Customer extends ClassMap {
    @Id(procedure = "GET_CUSTOMER_SEQ" , seq = "CLI")
    String id;
    String name;
    String phone;
    String address;
    public Customer(){}
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
    @Override
    public void controle(Connection arg0) throws Exception {
        
    }
}
