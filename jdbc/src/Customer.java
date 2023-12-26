import java.util.Scanner;

class Customer extends SuperMarket implements iCustomerData {
    private String customerName;
    private String customerAddress;
    private Scanner scanner = new Scanner(System.in);

    Customer(String nama, String Alamat, String marketName, String kasir) {
        super(marketName, kasir);
        this.customerName = nama;
        this.customerAddress = Alamat;
    }

    @Override
    public void inputCustomerData() {
        System.out.print("Nama Pelanggan : ");
        customerName = scanner.nextLine();
        System.out.print("Alamat         : ");
        customerAddress = scanner.nextLine();
        System.out.println("========================");
    }
}