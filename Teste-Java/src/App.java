import Enum.OrderStatus;
import entites.Client;
import entites.Order;
import entites.OrderItem;
import entites.Product;
import java.util.Locale;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class App{
    public static void main (String [] args){
        
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
        
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        String niver = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(niver, fmt1);
        Client client = new Client(name , email, birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        LocalDate moment = LocalDate.now();
        Order order = new Order(moment, status, client);

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i<=n; i++){
            System.out.println("Enter #" + i + " item data: " );
            System.out.print("Product Name: ");
            String prod_name = sc.nextLine();
            System.out.print("Product Price: ");
            Double price = sc.nextDouble();
            
            Product product = new Product(prod_name, price);

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

            sc.nextLine();

            OrderItem orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }   

        System.out.println();
        System.out.println("ORDER SUMMARY: ");
        System.out.println(order);

        sc.close();
    }
}