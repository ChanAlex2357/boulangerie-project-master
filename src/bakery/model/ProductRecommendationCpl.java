package bakery.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class ProductRecommendationCpl extends ClassMap {

    String recommendationId;
    String recommendationDateMin;
    String recommendationDateMax;
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

    public ProductRecommendationCpl() {}

    public static List<ProductRecommendationCpl> getAllInstances(Connection conn) throws Exception {
        List<ProductRecommendationCpl> recommendations = new ArrayList<>();
        String query = "SELECT * FROM ProductRecommendationCpl";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ProductRecommendationCpl recommendation = new ProductRecommendationCpl();
                recommendation.setRecommendationId(rs.getString("recommendation_id"));
                recommendation.setRecommendationDateMin(rs.getString("recommendation_date_min"));
                recommendation.setRecommendationDateMax(rs.getString("recommendation_date_max"));
                recommendation.setProductId(rs.getString("product_id"));
                recommendation.setProductName(rs.getString("product_name"));
                recommendation.setProductDescription(rs.getString("product_description"));
                recommendation.setProductSalePrice(rs.getDouble("product_sale_price"));
                recommendation.setProductTypeId(rs.getString("product_type_id"));
                recommendation.setProductTypeValue(rs.getString("product_type_value"));
                recommendation.setProductTypeDescription(rs.getString("product_type_description"));
                recommendation.setUnitId(rs.getString("unit_id"));
                recommendation.setUnitValue(rs.getString("unit_value"));
                recommendation.setUnitDescription(rs.getString("unit_description"));
                recommendations.add(recommendation);
            }
        }
        return recommendations;
    }

    public static List<ProductRecommendationCpl> filter(Connection conn, Date dateMin, Date dateMax, double minPrice, double maxPrice, String productTypeId) throws Exception {
        List<ProductRecommendationCpl> recommendations = new ArrayList<>();
        String query = "SELECT * FROM ProductRecommendationCpl WHERE recommendation_date_min >= ? AND recommendation_date_max <= ? AND product_sale_price BETWEEN ? AND ? AND product_type_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, dateMin);
            stmt.setDate(2, dateMax);
            stmt.setDouble(3, minPrice);
            stmt.setDouble(4, maxPrice);
            stmt.setString(5, productTypeId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProductRecommendationCpl recommendation = new ProductRecommendationCpl();
                    recommendation.setRecommendationId(rs.getString("recommendation_id"));
                    recommendation.setRecommendationDateMin(rs.getString("recommendation_date_min"));
                    recommendation.setRecommendationDateMax(rs.getString("recommendation_date_max"));
                    recommendation.setProductId(rs.getString("product_id"));
                    recommendation.setProductName(rs.getString("product_name"));
                    recommendation.setProductDescription(rs.getString("product_description"));
                    recommendation.setProductSalePrice(rs.getDouble("product_sale_price"));
                    recommendation.setProductTypeId(rs.getString("product_type_id"));
                    recommendation.setProductTypeValue(rs.getString("product_type_value"));
                    recommendation.setProductTypeDescription(rs.getString("product_type_description"));
                    recommendation.setUnitId(rs.getString("unit_id"));
                    recommendation.setUnitValue(rs.getString("unit_value"));
                    recommendation.setUnitDescription(rs.getString("unit_description"));
                    recommendations.add(recommendation);
                }
            }
        }
        return recommendations;
    }

    // Getters and Setters
    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getRecommendationDateMin() {
        return recommendationDateMin;
    }

    public void setRecommendationDateMin(String recommendationDateMin) {
        this.recommendationDateMin = recommendationDateMin;
    }

    public String getRecommendationDateMax() {
        return recommendationDateMax;
    }

    public void setRecommendationDateMax(String recommendationDateMax) {
        this.recommendationDateMax = recommendationDateMax;
    }

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
