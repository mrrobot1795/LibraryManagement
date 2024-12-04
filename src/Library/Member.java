package Library;

import java.util.ArrayList;

public class Member {
    private String memberId;
    private String name;
    private ArrayList<Book> issuedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void issueBook(Book book) {
        issuedBooks.add(book);
        book.issueBook();
    }

    public void returnBook(Book book) {
        if (issuedBooks.remove(book)) {
            book.returnBook();
        } else {
            System.out.println("This book was not issued to this member");
        }
    }

    @Override
    public String toString() {
        return "Member [ID = " + memberId + ", Name = " + name + ", Issued Books = " + issuedBooks + "]";
    }
}
