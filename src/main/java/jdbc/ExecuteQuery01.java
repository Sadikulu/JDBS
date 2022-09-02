package jdbc;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Lcvrt.3992");
        Statement st=con.createStatement();

        //1. Örnek: companies tablosundan en yüksek ikinci
        // number_of_employees değeri olan
        // company ve number_of_employees değerlerini çağırın.

        //1.yol offset ve fetch next kullanarak
        String sql1="select company,number_of_employees \n" +
                "from companies\n" +
                "order by number_of_employees desc \n" +
                "offset 1 row\n" +
                "fetch next 1 row only";
        ResultSet result1=st.executeQuery(sql1);
        while(result1.next()){
            System.out.println(result1.getString("company")+
                    "-->"+result1.getInt("number_of_employees"));
        }

        //2.yol Subquary kullanarak
        String sql2="select company,number_of_employees \n" +
                "from companies\n" +
                "where number_of_employees=\n" +
                "(select max(number_of_employees) from companies where number_of_employees<\n" +
                "(select max(number_of_employees) from companies));";
        ResultSet result2=st.executeQuery(sql2);
        while(result2.next()){
            System.out.println(result2.getString(1)+
                    "-->"+result2.getInt(2));
        }
        con.close();
        st.close();
        result1.close();
        result2.close();




    }
}
