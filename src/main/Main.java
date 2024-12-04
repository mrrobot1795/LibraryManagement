package main;

import Library.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Library Management System");

        while (true) {
            System.out.println("\n1. Add Book\n2. Register Member\n3. Issue Book\n4. Return Book\n5. Search Book\n6. Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Copies: ");
                    int copies = scanner.nextInt();
                    library.addBook(new Book(title, author, isbn, copies));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    library.registerMember(new Member(memberId, name));
                    break;

                case 3:
                    System.out.print("Enter ISBN: ");
                    String issueIsbn = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String issueMemberId = scanner.nextLine();
                    library.issueBook(issueIsbn, issueMemberId);
                    break;

                case 4:
                    System.out.print("Enter ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    System.out.print("Enter Member ID: ");
                    String returnMemberId = scanner.nextLine();
                    library.returnBook(returnIsbn, returnMemberId);
                    break;

                case 5:
                    System.out.print("Enter Book Title: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}