package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import jakarta.servlet.http.HttpServletRequest;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class ProductRecommandationCpl  extends ClassMap {
    @Id(procedure = "GET_PRODUCT_RECOMMANDATION_SEQ" , seq = "PRC")
    String id;
    Date dateDebut;
    Date dateFin;
    String productName;
    String productDesc;
    double productPrice;
    String typeValue;
    String typeDesc;
    String unitValue;
    String unitDesc;
    String recipeName;
    String recipeType;
    String recipeValue;
    public ProductRecommandationCpl(String id, Date dateDebut, Date dateFin, String productName, String productDesc,
            double productPrice, String typeValue, String typeDesc, String unitValue, String unitDesc,
            String recipeName, String recipeType, String recipeValue) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.typeValue = typeValue;
        this.typeDesc = typeDesc;
        this.unitValue = unitValue;
        this.unitDesc = unitDesc;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.recipeValue = recipeValue;
    }
    public ProductRecommandationCpl() {
    }
    @Override
    public void controle(Connection arg0) throws Exception {}
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public String getTypeValue() {
        return typeValue;
    }
    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
    public String getTypeDesc() {
        return typeDesc;
    }
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
    public String getUnitValue() {
        return unitValue;
    }
    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }
    public String getUnitDesc() {
        return unitDesc;
    }
    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }
    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
    public String getRecipeType() {
        return recipeType;
    }
    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }
    public String getRecipeValue() {
        return recipeValue;
    }
    public void setRecipeValue(String recipeValue) {
        this.recipeValue = recipeValue;
    }
}
