import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


abstract class SuperMarket {
    private String supermarketName;
    private String kasir;
    private Scanner input = new Scanner(System.in);

    SuperMarket(String name, String kasir) {
        this.supermarketName = name;
        this.kasir = kasir;
    }

    void displaySupermarketInfo() {
        System.out.println("-------SUPERMART-------");
        System.out.println("========================");
            Date tglSekarang = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MM yyyy");
            String tglFormat = sdf.format(tglSekarang);
        System.out.println("Tanggal     : "+tglFormat);
            Date waktu = new Date();
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            String waktuFormat = sdf2.format(waktu);
        System.out.println("Waktu       : "+waktuFormat);
        
        System.out.print("Kasir       : ");
        kasir = input.nextLine();
        System.out.println("========================");
    }
}