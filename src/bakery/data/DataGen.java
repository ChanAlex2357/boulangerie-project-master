package bakery.data;

import java.sql.Connection;

import mg.jca.gfja.mapping.ClassMap;

public interface DataGen {
    public void generate(Connection conn) throws Exception;
}
