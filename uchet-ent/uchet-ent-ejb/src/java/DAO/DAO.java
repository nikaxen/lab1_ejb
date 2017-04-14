
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@Stateless
public class DAO {
    
    static DataSource ds;
    static Connection connection;
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/uchet?useSSL=false";
    static final String LOGIN = "root";
    static final String PASSWORD = "root";
    
    public static void initConnection() {
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/JDBCuchet");
        } catch (NamingException ex) {

        }
    }

    public static void connect() {
        initConnection();
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {

        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {

        }
    }
}
