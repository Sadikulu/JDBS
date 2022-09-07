package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "Lcvrt.3992");
        Statement st = con.createStatement();
        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K'
        //int s1=st.executeUpdate("Insert into ogrenciler values (300, 'Sena Can', 12, 'K')");
        //System.out.println(s1+" satır database'e eklendi");

//SORU: Öğrenciler tablosuna birden fazla veri ekleyin
// (400, 'Sena Can', 12, 'K'),
// (401, 'Sena Can', 12, 'K'),
// (402, 'Sena Can', 12, 'K')
        /*String[] veri={"Insert into ogrenciler values (400, 'Sena Can', 12, 'K')",
                "Insert into ogrenciler values (401, 'Sena Can', 12, 'K')",
                "Insert into ogrenciler values (402, 'Sena Can', 12, 'K')"};
        int count=0;
        for (String each:veri) {
            st.executeUpdate(each);
            count++;
        }
        System.out.println(count+" data eklendi");*/
        //2.yol
        String[] veri2={"Insert into ogrenciler values (500, 'Sena Can', 12, 'K')",
                "Insert into ogrenciler values (501, 'Sena Can', 12, 'K')",
                "Insert into ogrenciler values (502, 'Sena Can', 12, 'K')"};
        for (String each: veri2) {
            st.addBatch(each);//yukarıdaki dataların hepsini birleştiriyor
        }
        st.executeBatch();//dataları tek seferde gönderiyor


    }
}
