package bakery.model;

import java.sql.Connection;

import jakarta.servlet.http.HttpServletRequest;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Product extends ClassMap {

    @Id(procedure = "GET_PRODUCT_SEQ" , seq = "PRD")
    String id;
    String name;
    String description;
    double purhcasePrice;
    double salePrice;
    @Attribute(name = "is_purchase")
    boolean isPurchase;
    @Attribute(name = "is_sale")
    boolean isSale;

    @Attribute(name = "unit_id")
    String unitId;
    @Attribute(name = "product_type_id")
    String productTypeId;


    @Override
    public void controle(Connection arg0) throws Exception {}

    public Product(){}
    public Product(String name,String description,String purchase, String sale,String purhcasePrice, String salePrice,String unit,String productType){
        setName(name);
        setDescription(description);
        setUnitId(unit);
        setProductTypeId(productType);
        setPurchase(purchase);
        setSale(sale);
        setPurhcasePrice(longuerClePrimaire);
        setSalePrice(longuerClePrimaire);
    }

    public void setPurchase(String purchase) {
        boolean b = Boolean.valueOf(purchase);
        setPurchase(b);
    }

    public void setSale(String sale) {
        boolean b = Boolean.valueOf(sale);
        setSale(b);
    }

    public void setPurhcasePrice(String value){
        double doubleValue = Double.valueOf(value);
        setPurhcasePrice(doubleValue);        
    }

    public void setSalePrice(String value){
        double doubleValue = Double.valueOf(value);
        setSalePrice(doubleValue);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurhcasePrice() {
        return purhcasePrice;
    }

    public void setPurhcasePrice(double purhcasePrice) {
        if (isPurchase() && purhcasePrice <= 0) {
            throw new NumberFormatException("Purchase price must be greater than 0");
        }
        this.purhcasePrice = purhcasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        if (isSale() && salePrice <= 0) {
            throw new NumberFormatException("Sale price must be greater than 0");
        }
        this.salePrice = salePrice;
    }

    public boolean isPurchase() {
        return isPurchase;
    }

    public void setPurchase(boolean isPurchase) {
        System.out.println();
        this.isPurchase = isPurchase;
    }

    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean isSale) {
        this.isSale = isSale;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }    
}
