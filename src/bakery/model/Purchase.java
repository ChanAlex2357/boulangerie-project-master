package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Purchase extends ClassMap {

    @Id(procedure = "GET_PURCHASE_SEQ", seq = "PUR")
    String id;
    @Attribute(name = "purchase_date")
    Date purchaseDate;
    @Attribute(name = "invoice_id")
    String invoiceId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Purchase() {}

    public Purchase(Date purchaseDate, String invoiceId) {
        setPurchaseDate(purchaseDate);
        setInvoiceId(invoiceId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
