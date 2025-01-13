package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class SupplierInvoice extends ClassMap {

    @Id(procedure = "GET_SUPPLIER_INVOICE_SEQ", seq = "SI")
    String id;
    @Attribute(name = "payment_due_date")
    Date paymentDueDate;
    double amount;
    @Attribute(name = "supplier_id")
    String supplierId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public SupplierInvoice() {}

    public SupplierInvoice(Date paymentDueDate, double amount, String supplierId) {
        setPaymentDueDate(paymentDueDate);
        setAmount(amount);
        setSupplierId(supplierId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
}
