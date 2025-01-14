package bakery.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class ProductCpl extends ClassMap {

    String productId;
    String productName;
    String productDescription;
    double productSalePrice;
    String productTypeId;
    String productTypeValue;
    String productTypeDescription;
    String unitId;
    String unitValue;
    String unitDescription;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public ProductCpl() {}

    public static List<ProductCpl> getAllInstances(Connection conn) throws Exception {
        List<ProductCpl> products = new ArrayList<>();
        String query = "SELECT * FROM ProductCpl";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ProductCpl product = new ProductCpl();
                product.setProductId(rs.getString("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setProductDescription(rs.getString("product_description"));
                product.setProductSalePrice(rs.getDouble("product_sale_price"));
                product.setProductTypeId(rs.getString("product_type_id"));
                product.setProductTypeValue(rs.getString("product_type_value"));
                product.setProductTypeDescription(rs.getString("product_type_description"));
                product.setUnitId(rs.getString("unit_id"));
                product.setUnitValue(rs.getString("unit_value"));
                product.setUnitDescription(rs.getString("unit_description"));
                products.add(product);
            }
        }
        return products;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductSalePrice() {
        return productSalePrice;
    }

    public void setProductSalePrice(double productSalePrice) {
        this.productSalePrice = productSalePrice;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductTypeValue() {
        return productTypeValue;
    }

    public void setProductTypeValue(String productTypeValue) {
        this.productTypeValue = productTypeValue;
    }

    public String getProductTypeDescription() {
        return productTypeDescription;
    }

    public void setProductTypeDescription(String productTypeDescription) {
        this.productTypeDescription = productTypeDescription;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }
}
