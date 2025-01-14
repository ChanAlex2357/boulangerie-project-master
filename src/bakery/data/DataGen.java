package bakery.data;

import java.sql.Connection;


public interface DataGen {
    public void generate(Connection conn) throws Exception;
}
