package bakery.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mg.jca.gfja.annotations.Attribute;
import mg.jca.gfja.annotations.Entity;
import mg.jca.gfja.mapping.ClassMap;

@Entity
public class BakerCommissionLib extends ClassMap{
    @Attribute(name = "baker_id")
    String idBaker;
    String name;
    @Attribute(name = "total_commission")
    double totalCommission;

    public BakerCommissionLib(String idBaker, String name, double totalCommission) {
        this.idBaker = idBaker;
        this.name = name;
        this.totalCommission = totalCommission;
    }

    public BakerCommissionLib() {
    }

    @Override
    public void controle(Connection arg0) throws Exception {}

    public BakerCommissionLib(String name, double totalCommission) {
        this.name = name;
        this.totalCommission = totalCommission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public BakerCommissionLib[] filter(String dmin, String dmax, Connection conn) throws Exception {
        if((dmin==null || dmin.equals("")) && (dmax==null || dmax.equals(""))) {
            return getAll(conn);
        }
        List<BakerCommissionLib>  bakerCommissionLib = new ArrayList<>();
        String query = "SELECT baker_id,name,sum(amount) as total_commission FROM BakerCommissionLib WHERE 1=1 ";
        if((dmin!=null || !dmin.equals("")) && (dmax==null || dmax.equals(""))) {
            dmax=dmin;
        }
        if((dmin==null || dmin.equals("")) && (dmax!=null || !dmax.equals(""))) {
            dmin=dmax;
        }
        query+="and (date_commission between '"+dmin+"' and '"+dmax+"') group by baker_id,name";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            System.out.println(query);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BakerCommissionLib bakerCommLib = new BakerCommissionLib();
                    bakerCommLib.setIdBaker(rs.getString("baker_id"));
                    bakerCommLib.setName(rs.getString("name"));
                    bakerCommLib.setTotalCommission(rs.getDouble("total_commission"));
                    bakerCommissionLib.add(bakerCommLib);
                }
            }
        }
        return bakerCommissionLib.toArray(new BakerCommissionLib[0]);
    }

    public String getIdBaker() {
        return idBaker;
    }

    public void setIdBaker(String idBaker) {
        this.idBaker = idBaker;
    }
}
