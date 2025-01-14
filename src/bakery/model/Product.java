package bakery.model;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Product extends ClassMap {

    @Id(procedure = "GET_PRODUCT_SEQ", seq = "PRD")
    String id;
    String name;
    String description;
    @Attribute(name = "sale_price")
    double salePrice;
    @Attribute(name = "unit_id")
    String unitId;
    @Attribute(name = "product_type_id")
    String productTypeId;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public Product() {}

    public Product(String name, String description, String salePrice, String unitId, String productTypeId) {
        setName(name);
        setDescription(description);
        setSalePrice(salePrice);
        setUnitId(unitId);
        setProductTypeId(productTypeId);
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = Double.parseDouble(salePrice);
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


    @Override
    public ClassMap save(Connection conn) throws Exception {
        super.save(conn);
        generaInventory(conn);
        return this;
    }

    public Inventory generaInventory(Connection conn) throws Exception{
        Inventory inventory =  new Inventory();
        inventory.setProductId(this.getId());
        inventory.setActualQuantity(0);
        inventory.setInventoryDate(Date.valueOf( LocalDate.now()));
        inventory.save(conn);
        return inventory;
    }
}
