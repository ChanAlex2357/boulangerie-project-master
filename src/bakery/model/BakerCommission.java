package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class BakerCommission extends ClassMap{
    @Id(procedure = "GET_BAKERCOMMISSION_SEQ", seq = "BAKCO")
    String id;
    double amount;
    @Attribute(name = "date_commission")
    Date dateCommission;
    @Attribute(name = "sale_id")
    String saleId;
    @Attribute(name = "baker_id")
    String bakerId;

    public BakerCommission() {
    }

    public BakerCommission(double amount, Date dateCommission, String saleId, String bakerId) {
        this.amount = amount;
        this.dateCommission = dateCommission;
        this.saleId = saleId;
        this.bakerId = bakerId;
    }

    public BakerCommission(String id, double amount, Date dateCommission, String saleId, String bakerId) {
        this.id = id;
        this.amount = amount;
        this.dateCommission = dateCommission;
        this.saleId = saleId;
        this.bakerId = bakerId;
    }

    @Override
    public void controle(Connection arg0) throws Exception {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateCommission() {
        return dateCommission;
    }

    public void setDateCommission(Date dateCommission) {
        this.dateCommission = dateCommission;
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getBakerId() {
        return bakerId;
    }

    public void setBakerId(String bakerId) {
        this.bakerId = bakerId;
    }
}
