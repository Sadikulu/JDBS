package jdbcPractice;

import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1--Driver yükle
        Class.forName("org.postgresql.Driver");
        //2--Bağlantı oluştur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Lcvrt.3992");
        //3--Statement oluştur
        Statement st = con.createStatement();
        //4--ResultSet oluştur
        ResultSet veri=st.executeQuery("SELECT * FROM ogrenciler");
        //5--Sonuç al
        while (veri.next()) {
            /*System.out.println(veri.getInt(1)+
                    "--"+veri.getString(2) +
                    "--" + veri.getString(3)+
                    "--"+veri.getString(4));*/
            System.out.printf("%-6d %-15.15s %-8s %-8s\n",
                    veri.getInt(1),
                    veri.getString(2),
                    veri.getString(3),
                    veri.getString(4));

        }
        //6--kapat
        con.close();
        st.close();
    }
}
