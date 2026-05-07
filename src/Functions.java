import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

public class Functions {
    
    // --- Class Variables ---
    private JSONArray bookList; 
    private final String FILE_PATH = "data.json"; 
    private Scanner scanner;

    // --- Constructor ---
    public Functions() {
        scanner = new Scanner(System.in);
        loadData(); 
    }

    // --- Data Management Methods ---

    private void loadData() {
        try {
            if (!Files.exists(Paths.get(FILE_PATH))) {
                bookList = new JSONArray();
                return;
            }
            
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            
            if (content.trim().isEmpty()) {
                bookList = new JSONArray();
            } else {
                bookList = new JSONArray(content);
            }
        } catch (Exception e) {
            System.out.println("[ERROR] Failed to load database: " + e.getMessage());
            bookList = new JSONArray(); 
        }
    }

    private void saveData() {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(bookList.toString(4)); 
        } catch (Exception e) {
            System.out.println("[ERROR] Failed to save database: " + e.getMessage());
        }
    }

    // --- User Operations ---

    public void addBook() {
        System.out.println("\n--- Add a New Book ---");
        
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        
        System.out.print("Is it available? (true/false): ");
        boolean available = Boolean.parseBoolean(scanner.nextLine());

        PhysicalBook newBook = new PhysicalBook(title, author, isbn, available);

        // [NEW] Wrapped the JSON logic in a try-catch to satisfy the compiler
        try {
            JSONObject bookJson = new JSONObject();
            bookJson.put("title", newBook.getTitle());
            bookJson.put("author", newBook.getAuthor());
            bookJson.put("isbn", newBook.getIsbn());
            bookJson.put("available", newBook.getAvailable());

            bookList.put(bookJson);
            saveData();
            
            System.out.println("[SUCCESS] Book '" + title + "' has been added to the system.");
        } catch (JSONException e) {
            System.out.println("[ERROR] Failed to process book data: " + e.getMessage());
        }
    }
    
    public void viewAll() {
        System.out.println("\n--- Library Inventory ---");
        
        if (bookList.length() == 0) {
            System.out.println("The library is currently empty.");
            return;
        }

        try {
            for (int i = 0; i < bookList.length(); i++) {
                JSONObject book = bookList.getJSONObject(i);
                String status = book.getBoolean("available") ? "Available" : "Checked Out";
                
                System.out.println((i + 1) + 
				". Title: " + book.getString("title") + 
				" | Author: " + book.getString("author") +  
				" | ISBN: " + book.getString("isbn") + 
				" | Status: " + status);
            }
        } catch (JSONException e) {
            System.out.println("[ERROR] Corrupted data found while reading the list.");
        }
    }
    
    public void checkStatus() {
        System.out.print("\nEnter the ISBN of the book to check: ");
        String searchIsbn = scanner.nextLine();

        try {
            for (int i = 0; i < bookList.length(); i++) {
                JSONObject book = bookList.getJSONObject(i);
                if (book.getString("isbn").equals(searchIsbn)) {
                    String status = book.getBoolean("available") ? "Available" : "Checked Out";
                    System.out.println("Status for '" + book.getString("title") + "': " + status);
                    return; 
                }
            }
            System.out.println("[NOT FOUND] No book matches the ISBN: " + searchIsbn);
        } catch (JSONException e) {
            System.out.println("[ERROR] Failed to read book status.");
        }
    }
    
    public void updateStatus() {
        System.out.print("\nEnter the ISBN of the book to update: ");
        String searchIsbn = scanner.nextLine();

        try {
            for (int i = 0; i < bookList.length(); i++) {
                JSONObject book = bookList.getJSONObject(i);
                if (book.getString("isbn").equals(searchIsbn)) {
                    boolean currentStatus = book.getBoolean("available");
                    
                    book.put("available", !currentStatus); 
                    saveData(); 
                    
                    String newStatus = !currentStatus ? "Available" : "Checked Out";
                    System.out.println("[SUCCESS] The status for '" + book.getString("title") + "' is now: " + newStatus);
                    return;
                }
            }
            System.out.println("[NOT FOUND] No book matches the ISBN: " + searchIsbn);
        } catch (JSONException e) {
            System.out.println("[ERROR] Failed to update book status.");
        }
    }
    
    public void removeBook() {
        System.out.print("\nEnter the ISBN of the book to remove: ");
        String searchIsbn = scanner.nextLine();

        try {
            for (int i = 0; i < bookList.length(); i++) {
                JSONObject book = bookList.getJSONObject(i);
                if (book.getString("isbn").equals(searchIsbn)) {
                    String title = book.getString("title");
                    
                    bookList.remove(i); 
                    saveData(); 
                    
                    System.out.println("[SUCCESS] The book '" + title + "' has been permanently removed.");
                    return;
                }
            }
            System.out.println("[NOT FOUND] No book matches the ISBN: " + searchIsbn);
        } catch (JSONException e) {
            System.out.println("[ERROR] Failed to remove the book.");
        }
    }   
}