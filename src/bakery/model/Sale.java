package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;
import mg.jca.gfja.utils.GenUtils;

@Entity
public class Sale extends ClassMap {

    @Id(procedure = "GET_SALE_SEQ", seq = "SAL")
    String id;
    @Attribute(name = "sale_date")
    Date saleDate;
    double amount;
    @Attribute(name = "customer_id")
    String customerId;
    @Attribute(name = "baker_id")
    String bakerId;

    SaleDetails[] saleDetails;
    
    

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

    public void setSaleDate(String date) {
        this.saleDate = Date.valueOf(date);
    }

    public SaleDetails[] getSaleDetails(){
        return this.saleDetails;
    }

    public void calculerSaleAmount(Connection conn)throws Exception{
        double amount = 0;
        String msg = "";
        for (SaleDetails saleDetails : getSaleDetails(conn)) {
            double qte = saleDetails.getQuantity();
            double pu = saleDetails.getUnitPrice(); 
            amount +=  qte * pu;
            msg +=" > "+qte+" * "+pu+" | \n";
        }
        setAmount(amount);
        // throw new NumberFormatException(msg+" ==> "+amount);
    }
    public void saveDetails(Connection conn)throws Exception{
        for (SaleDetails saleDetails : getSaleDetails(conn)) {
            saleDetails.setSaleId(this.getId());
            saleDetails.save(conn);
        }
    }
    @Override
    public ClassMap save(Connection conn) throws Exception {
        calculerSaleAmount(conn);
        super.save(conn);
        saveDetails(conn);
        return this;
    }

    public void setSaleDetails(SaleDetails[] saleDetails) {
        this.saleDetails = saleDetails;
    }
    public SaleDetails[] getSaleDetails(Connection conn) throws Exception {
        if (saleDetails == null || saleDetails.length < 0 ) {
            SaleDetails ref = new SaleDetails();
            ref.setSaleId(this.getId());
            SaleDetails[] details = new GenUtils().searchEntities(ref,"", conn);
            setSaleDetails(details);
        }
        return saleDetails;
    }

    public String getBakerId() {
        return bakerId;
    }

    public void setBakerId(String bakerId) {
        this.bakerId = bakerId;
    }
}
