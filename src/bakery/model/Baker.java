package bakery.model;

import java.sql.Connection;
import java.sql.Date;
import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class Baker extends ClassMap {
    @Id(procedure = "GET_BAKER_SEQ", seq = "BAK")
    String id;
    String name;
    double commission;
    @Attribute(name = "hire_date")
    Date hireDate;

    public Baker(String name, Date hireDate, double commission) {
        this.name = name;
        this.commission = commission;
        this.hireDate = hireDate;
    }

    public Baker(String Id, String name, double commission, Date hireDate) {
        this.id = Id;
        this.name = name;
        this.commission = commission;
        this.hireDate = hireDate;
    }

    public Baker() {
    }

    @Override
    public void controle(Connection arg0) throws Exception {}

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
