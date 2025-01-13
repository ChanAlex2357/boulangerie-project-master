package bakery.model;

import java.sql.Connection;
import java.sql.Date;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class PreOrder extends ClassMap {

    @Id(procedure = "GET_PREORDER_SEQ", seq = "PO")
    String id;
    @Attribute(name = "pre_order_date")
    Date preOrderDate;

    @Override
    public void controle(Connection arg0) throws Exception {}

    public PreOrder() {}

    public PreOrder(Date preOrderDate) {
        setPreOrderDate(preOrderDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPreOrderDate() {
        return preOrderDate;
    }

    public void setPreOrderDate(Date preOrderDate) {
        this.preOrderDate = preOrderDate;
    }
}
