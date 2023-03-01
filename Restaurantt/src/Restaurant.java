import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    private ArrayList<String> menu;
    private ArrayList<Double> prices;

    public Restaurant() {
        menu = new ArrayList<String>();
        prices = new ArrayList<Double>();
        // Initialize with some items on the menu
        menu.add("Rice");
        prices.add(120.0);
        menu.add("Soda");
        prices.add(50.0);
        menu.add("beef");
        prices.add(300.0);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i) + " - Ksh" + prices.get(i));
        }
    }

    public void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item name: ");
        String item = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        menu.add(item);
        prices.add(price);
        System.out.println(item + " added to menu.");
    }

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Place your order (enter item names, one per line; enter 'done' when finished):");
        ArrayList<String> order = new ArrayList<String>();
        String item = "";
        while (!item.equals("done")) {
            item = scanner.nextLine();
            if (menu.contains(item)) {
                order.add(item);
            } else if (!item.equals("done")) {
                System.out.println(item + " is not on the menu.");
            }
        }
        double total = 0;
        for (String o : order) {
            int index = menu.indexOf(o);
            double price = prices.get(index);
            total += price;
        }
        System.out.println("Your order total is $" + total);
    }

    public void makePayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();
        System.out.println("Payment of ksh" + payment + " made via mobile money.");
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display menu");
            System.out.println("2. Add item to menu");
            System.out.println("3. Place order");
            System.out.println("4. Make payment");
            System.out.println("5. Quit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    restaurant.displayMenu();
                    break;
                case 2:
                    restaurant.addItem();
                    break;
                case 3:
                    restaurant.placeOrder();
                    break;
                case 4:
                    restaurant.makePayment();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
