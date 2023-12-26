import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateNewEmployee {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void insertEmployeeData(Scanner scanNEW) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO Kasir (ID_Kasir, Nama_Kasir, Sandi) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----MEMBUAT DATA LOGIN BARU----");

                System.out.print("Masukkan ID : ");
                String ID = scanNEW.next();

                System.out.print("Masukkan Nama: ");
                String nama = scanNEW.next();

                System.out.print("Masukkan Sandi : ");
                String Sandi = scanNEW.next();

                preparedStatement.setString(1, ID);
                preparedStatement.setString(2, nama);
                preparedStatement.setString(3, Sandi);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Berhasil menambah data login baru");
                } else {
                    System.out.println("Tidak dapat menambah data login baru");
                }

                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
