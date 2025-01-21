package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class SaleDetails extends ClassMap {

    @Id(procedure = "GET_SALE_DETAILS_SEQ", seq = "SALEDET")
    String id;
    @Attribute(name = "quantity")
    double quantity;
    @Attribute(name = "unit_price")
    double unitPrice;
    @Attribute(name = "product_id")
    String productId;
    @Attribute(name = "sale_id")
    String saleId;

    public SaleDetails(){}
    public SaleDetails(String product, String quantite) {
        setProductId(product);
        setQuantity(Double.valueOf(quantite));
    }

    public static SaleDetails[] generateSaleDetails(String[] products, String[] quantity , Connection conn) throws Exception {
        SaleDetails[] saleDetails = new SaleDetails[products.length];
        for (int i = 0; i < saleDetails.length; i++) {
            saleDetails[i] = new SaleDetails(products[i],quantity[i]);
        }
        return saleDetails;
    }

    public Product getProduct(Connection conn) throws Exception{
        Product ref = new Product();
        ref.setId(getProductId());
        return new Product().getById(conn);
    }

    @Override
    public void controle(Connection arg0) throws Exception {
        if (this.getSaleId() == null ) {
            throw new Exception("Vente details dessocier d'une vente");
        }

        if (unitPrice <=0) {
            Product product = getProduct(arg0);
            unitPrice = product.getSalePrice();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
