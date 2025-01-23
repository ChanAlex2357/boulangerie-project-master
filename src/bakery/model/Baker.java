package bakery.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.annotations.Id;
import mg.jca.gfja.mapping.ClassMap;
import mg.jca.gfja.utils.GenUtils;

@Entity
public class Baker extends ClassMap {
    @Id(procedure = "GET_BAKER_SEQ", seq = "BAK")
    String id;
    String name;
    double commission;
    @Attribute(name = "hire_date")
    Date hireDate;
    @Attribute(name = "genre_id")
    String idGenre;

    public Baker(String name, Date hireDate, double commission,String idGenre) {
        this.name = name;
        this.commission = commission;
        this.hireDate = hireDate;
        this.idGenre = idGenre;
    }

    public Baker(String Id, String name, double commission, Date hireDate,String idGenre) {
        this.id = Id;
        this.name = name;
        this.commission = commission;
        this.hireDate = hireDate;
        this.idGenre = idGenre;
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

    public String getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(String idGenre) {
        this.idGenre = idGenre;
    }
}
