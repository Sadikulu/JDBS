package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWork {
    //Postgresql bağlantısı metodu
    public Connection connet_to_db(String dbName, String user, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            if (con != null) {
                System.out.println("Bağlantı sağlandı");
            } else {
                System.out.println("Bağlantı sağlanamadı");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    //yeni table oluşturma metodu
    public void createTable(Connection con, String tableName) {
        //Statement objesi olulştur
        Statement st;
        try {
            String query = "CREATE TABLE " + tableName + "(empId serial, name varchar(200),email varchar(200),salary INTEGER, PRIMARY KEY (empId))";
            st = con.createStatement();
            st.executeUpdate(query);
            System.out.println("Table oluşturuldu.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
