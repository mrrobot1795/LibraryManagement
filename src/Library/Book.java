package Library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int availableCopies;

    public Book(String title, String author, String isbn, int availableCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void issueBook() {
        if (availableCopies > 0) {
            availableCopies--;
        } else {
            System.out.println("Book is not available for issue");
        }
    }

    public void returnBook() {
        availableCopies++;
    }

    @Override
    public String toString() {
        return "Book [Title = " + title + ", Author = " + author + ", ISBN = " + isbn + ", Available Copies = " + availableCopies + "]";
    }
}
