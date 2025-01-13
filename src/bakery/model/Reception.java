package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Reception extends ClassMap {

    @Id(procedure = "GET_RECEPTION_SEQ", seq = "REC")
    String id;
    @Attribute(name = "reception_date")
    java.sql.Date receptionDate;
    @Attribute(name = "order_id")
    String orderId;
    @Attribute(name = "supplier_invoice_id")
    String supplierInvoiceId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.sql.Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(java.sql.Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSupplierInvoiceId() {
        return supplierInvoiceId;
    }

    public void setSupplierInvoiceId(String supplierInvoiceId) {
        this.supplierInvoiceId = supplierInvoiceId;
    }

    @Override
    public void controle(Connection arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'controle'");
    }
}
