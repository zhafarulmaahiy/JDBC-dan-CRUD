import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {

    //Driver
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static void updateEmployeeCredentials(Scanner scanner) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "UPDATE Kasir SET Nama_Kasir = ?, Sandi = ? WHERE ID_Kasir = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                System.out.println("----UPDATE DATA LOGIN PEGAWAI----");
                System.out.print("ID Baru: ");
                String ID = scanner.next();
                
                System.out.print("Nama Baru: ");
                String Nama = scanner.next();

                System.out.print("Sandi : ");
                String Sandi = scanner.next();

                preparedStatement.setString(1, Nama);
                preparedStatement.setString(2, Sandi);
                preparedStatement.setString(3, ID);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Data login pegawai diupdate!");
                } else {
                    System.out.println("tidak ditemukan data pegawai dengan id tersebut");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
