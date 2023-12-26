import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void deleteEmployeeById() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM Kasir WHERE ID_Kasir = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Scanner del = new Scanner(System.in);
                System.out.println("----MENGHAPUS DATA LOGIN PEGAWAI----");
                System.out.print("Masukkan ID Kasir yang akan dihapus: ");
                int ID = del.nextInt();
                preparedStatement.setInt(1,ID);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("data Kasir berhasil dihapus!");
                } else {
                    System.out.println("Data Kasir tidak ditemukan");
                }
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
