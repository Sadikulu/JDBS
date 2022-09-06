package jdbcPractice;

import java.sql.*;

public class Query03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed", "postgres", "Lcvrt.3992");
        PreparedStatement ps=con.prepareStatement("SELECT * FROM ogrenciler");
        ResultSet rs=ps.executeQuery();
        ResultSetMetaData rsmd=rs.getMetaData();
        System.out.println("Sutun sayısı :"+rsmd.getColumnCount());
        System.out.println(rsmd.getColumnName(1));
        System.out.println(rsmd.getColumnName(2));
        System.out.println(rsmd.getColumnName(3));
        System.out.println(rsmd.getColumnName(4));


    }
}
