package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import jakarta.servlet.http.HttpServletRequest;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class ProductRecommandation  extends ClassMap {
    @Id(procedure = "GET_PRODUCT_RECOMMANDATION_SEQ" , seq = "PRC")
    String id;
    @Attribute(name = "id_product")
    String idProduct;
    Date dateDebut;
    Date dateFin;
    @Override
    public void controle(Connection arg0) throws Exception {}

    public ProductRecommandation(){}
    public ProductRecommandation(String idProduct,String dateDebut,String dateFin) {
        setIdProduct(idProduct);
        setDateDebut(dateDebut);
        setDateFin(dateFin);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {

        this.dateFin = dateFin;
    }
    public void setDateDebut(String dateDebut) {
        Date db=Date.valueOf(dateDebut);
        this.dateDebut = db;
    }
    public void setDateFin(String dateFin) {
        Date df=Date.valueOf(dateFin);
        this.dateFin = df;
    }

    public String getId() {
        return id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }
    
}
