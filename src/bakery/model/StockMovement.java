package bakery.model;

import java.sql.Connection;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class StockMovement extends ClassMap {

    @Id(procedure = "GET_STOCKMOVEMENT_SEQ", seq = "SM")
    String id;
    @Attribute(name = "entry")
    double entry;
    @Attribute(name = "exit")
    double exit;
    @Attribute(name = "movement_date")
    java.sql.Date movementDate;
    @Attribute(name = "source_id")
    String sourceId;
    @Attribute(name = "product_id")
    String productId;
    @Attribute(name = "movement_type_id")
    String movementTypeId;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getEntry() {
        return entry;
    }

    public void setEntry(double entry) {
        this.entry = entry;
    }

    public double getExit() {
        return exit;
    }

    public void setExit(double exit) {
        this.exit = exit;
    }

    public java.sql.Date getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(java.sql.Date movementDate) {
        this.movementDate = movementDate;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMovementTypeId() {
        return movementTypeId;
    }

    public void setMovementTypeId(String movementTypeId) {
        this.movementTypeId = movementTypeId;
    }

    @Override
    public void controle(Connection arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'controle'");
    }
}
