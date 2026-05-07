public abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;
    protected boolean available;

    public Book() {
    	// We make an empty constructor that we will use inside the PhysicalBook.java
    	// We applied the encapsulation method and passing data to the json
    }

    // Functions to set and fetch data from-to json

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}