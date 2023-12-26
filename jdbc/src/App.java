import java.sql.*;


public class App {
    public static void main(String[] args) {
        //test apakah database (localhost) sudah tersambung dengan VScode
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "");
            Statement myStatement = myConn.createStatement();
            ResultSet myResultSet = myStatement.executeQuery("select * from Kasir");

            while (myResultSet.next()) {
                System.out.println(myResultSet.getString("ID_kasir")+ ","+myResultSet.getString("Nama_Kasir")+","+myResultSet.getString("Sandi"));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}