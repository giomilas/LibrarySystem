import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	boolean run = true;
        Scanner scanner = new Scanner(System.in);
        Functions func = new Functions();

        while (run) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. View All");
            System.out.println("3. Check Status");
            System.out.println("4. Update Status");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.print("\nSelect your option: ");

            switch (scanner.nextInt()) {
                case 1 -> func.addBook();
                case 2 -> func.viewAll();
                case 3 -> func.checkStatus();
                case 4 -> func.updateStatus();
                case 5 -> func.removeBook();
                case 6 -> run = false;
            }
            
            scanner.close();
        }
    }
}