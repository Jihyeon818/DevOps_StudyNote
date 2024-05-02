package mgr;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionMgr {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Context ctx=new InitialContext();
            Context env=(Context)ctx.lookup("java:comp/env");
            DataSource ds=(DataSource)env.lookup("jdbc/pool");

            conn=ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    // select을 수행한 후 리소스 해제를 위한 메소드
    public static void close(Connection conn, Statement stmt, ResultSet rs) {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DML(insert, update, delete)을 수행한 후 리소스 해제를 위한 메소드
    public static void close(Connection conn, Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}