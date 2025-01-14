package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class ProductRecommendation extends ClassMap {

    @Id(procedure = "GET_PRODUCT_RECOMMENDATION_SEQ", seq = "PRR")
    String id;
    @Attribute(name = "product_id")
    String productId;
    @Attribute(name = "date_min")
    Date dateMin;
    @Attribute(name = "date_max")
    Date dateMax;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public ProductRecommendation() {}

    public ProductRecommendation(String productId, Date dateMin, Date dateMax) {
        setProductId(productId);
        setDateMin(dateMin);
        setDateMax(dateMax);
    }

    public ProductRecommendation(String idProduct,String dateDebut,String dateFin) {
        setProductId(idProduct);
        setDateDebut(dateDebut);
        setDateFin(dateFin);
    }
    public void setDateDebut(String dateDebut) {
        Date db=Date.valueOf(dateDebut);
        setDateMin(db);
    }
    public void setDateFin(String dateFin) {
        Date df=Date.valueOf(dateFin);
        setDateMax(df);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }
}
