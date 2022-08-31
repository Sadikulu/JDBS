package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //1.adım: Driver'a kaydol
        Class.forName("org.postgresql.Driver");

        //2.adım: Database'e bağlan
        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Lcvrt.3992");

        //3.adım: Statement oluştur.
        Statement st=con.createStatement();

        //4.adım: Query çalıştır
        //1.Örnek: "workers" adında bir table oluşturup
        // "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        String sql1="CREATE TABLE workers(worker_id VARCHAR(50),worker_name VARCHAR(50),worker_salary INT)";
        boolean result=st.execute(sql1);
        System.out.println(result);//false return yapar ,çünkü data çağırılmadı

        //2.Örnek: Table'e worker_address sutunu ekleyerek alter yapın
        String sql2="Alter table workers add worker_address VARCHAR(80)";
        st.execute(sql2);

        //3.Örnek: Drop workers table
        String sql3="Drop table workers";
        st.execute(sql3);

        //5.Adım: Bağlantı ve statementi kapat
        /*con.close();
        st.close();*/





    }
}
