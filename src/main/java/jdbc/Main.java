package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        //DBWork objesi oluştur
        DBWork db = new DBWork();
        //Connection metodunu çağır
        Connection con = db.connet_to_db("techproed", "postgres", "Lcvrt.3992");
        //yeni tablo oluştur metodunu çağır
        db.createTable(con,"employees");
    }
}
