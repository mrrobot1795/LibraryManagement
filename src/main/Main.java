package main;

import Library.*;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerConfig.getLogger(Main.class);

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        logger.info("Library Management System");

        while (true) {
            try {
                System.out.println("\n1. Add Book\n2. Register Member\n3. Issue Book\n4. Return Book\n5. Search Book\n6. Exit");
                System.out.print("Enter Choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        System.out.print("Enter Copies: ");
                        int copies = Integer.parseInt(scanner.nextLine());
                        library.addBook(new Book(title, author, isbn, copies));
                        logger.info("Book added: " + title);
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        library.registerMember(new Member(memberId, name));
                        logger.info("Member added: " + name);
                        break;

                    case 3:
                        System.out.print("Enter ISBN: ");
                        String issueIsbn = scanner.nextLine();
                        System.out.print("Enter Member ID: ");
                        String issueMemberId = scanner.nextLine();
                        library.issueBook(issueIsbn, issueMemberId);
                        logger.info("Book issued: " + issueIsbn + "to Member ID: " + issueMemberId);
                        break;

                    case 4:
                        System.out.print("Enter ISBN: ");
                        String returnIsbn = scanner.nextLine();
                        System.out.print("Enter Member ID: ");
                        String returnMemberId = scanner.nextLine();
                        library.returnBook(returnIsbn, returnMemberId);
                        logger.info("Book issued: " + returnIsbn + "by Member ID: " + returnMemberId);
                        break;

                    case 5:
                        System.out.print("Enter Book Title: ");
                        String searchTitle = scanner.nextLine();
                        library.searchBook(searchTitle);
                        logger.info("Book searched: " + searchTitle);
                        break;

                    case 6:
                        logger.info("Library Management System exited");
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        throw new IllegalArgumentException("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                logger.warning("Invalid input. Please enter a number");
            } catch (IllegalArgumentException e) {
                logger.warning(e.getMessage());
            } catch (Exception e) {
                logger.warning("An unexpected error occured: " + e.getMessage());
            }
        }
    }
}