package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Delivery extends ClassMap {

    @Id(procedure = "GET_DELIVERY_SEQ", seq = "DE")
    String id;
    @Attribute(name = "delivery_date")
    Date deliveryDate;
    @Attribute(name = "sale_id")
    String saleId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Delivery() {}

    public Delivery(Date deliveryDate, String saleId) {
        setDeliveryDate(deliveryDate);
        setSaleId(saleId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }
}
