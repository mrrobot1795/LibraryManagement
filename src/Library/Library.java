package Library;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Library {
    private static final Logger logger = LoggerConfig.getLogger(Library.class);
    private final ArrayList<Book> books;
    private final ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        try {
            if (book == null) throw new IllegalArgumentException("Book cannot be null");
            books.add(book);
            logger.info("Book added: " + book);
        } catch (IllegalArgumentException e) {
            logger.warning("Error adding book: " + e.getMessage());
        }
    }

    public void registerMember(Member member) {
        try {
            if (member == null) throw new IllegalArgumentException("Member cannot be null.");
            logger.info("Member registered: " + member);
            System.out.println("Member Registered: " + member);
        } catch (IllegalArgumentException e) {
            logger.warning("Error registering message: " + e.getMessage());
        }
    }

    public void issueBook(String isbn, String memberId) {
        try {
            Book book = findBookByIsbn(isbn);
            Member member = findMemberById(memberId);

            if (book == null) throw new NullPointerException("Book with ISBN " + isbn + " not found.");
            if (member == null) throw new NullPointerException("Member with ID " + memberId + " not found.");

            if (book.getAvailableCopies() > 0) {
                member.issueBook(book);
                logger.info("Book issued: " + book.getTitle() + " to " + member.getName());
            } else {
                throw new IllegalStateException("Book is not available for issuing.");
            }
        } catch (Exception e) {
            logger.severe("Error issuing book " + e.getMessage());
        }
    }

    public void returnBook(String isbn, String memberId) {
        try {
            Book book = findBookByIsbn(isbn);
            Member member = findMemberById(memberId);

            if (book == null) throw new NullPointerException("Book with ISBN " + isbn + " not found.");
            if (member == null) throw new NullPointerException("Member with ID " + memberId + " not found.");


            member.returnBook(book);
            logger.info("Book returned: " + book.getTitle() + " by " + member.getName());
        } catch (Exception e) {
            logger.severe("Error returning book: " + e.getMessage());
        }
    }

    public void searchBook(String title) {
        try {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    logger.info("Searching for book: " + book);
                    return;
                }
            }
            throw new IllegalArgumentException("Book with title \"" + title + "\" not found");
        } catch (Exception e) {
            logger.severe("Error searching book: " + e.getMessage());
        }
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }
}
