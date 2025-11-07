package com.MiniProjects;
import java.io.*;
import java.util.*;

    class InvalidReturnException extends Exception {
        public InvalidReturnException(String message) {
            super(message);
        }
    }

    class Book {
        int id;
        String title, author;
        boolean available = true;

        public Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }
    }

    class Member {
        int id;
        String name;
        List<Book> borrowed = new ArrayList<>();

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    class Library {
        HashMap<Integer, Book> books = new HashMap<>();
        HashMap<Integer, Member> members = new HashMap<>();
        PrintWriter log;

        public Library() throws IOException {
            log = new PrintWriter(new FileWriter("library_log.txt", true));
        }

        public void addBook(Book b) {
            books.put(b.id, b);
            log.println("Added book: " + b.title);
            log.flush();
        }

        public void addMember(Member m) {
            members.put(m.id, m);
            log.println("New member: " + m.name);
            log.flush();
        }

        public void issueBook(int bookId, int memberId) throws Exception {
            Book b = books.get(bookId);
            Member m = members.get(memberId);

            if (b == null || !b.available)
                throw new Exception("Book not available.");

            b.available = false;
            m.borrowed.add(b);
            log.println("Issued book: " + b.title + " to " + m.name);
            log.flush();
        }

        public void returnBook(int bookId, int memberId, int lateDays)
                throws InvalidReturnException {
            Member m = members.get(memberId);
            Book b = books.get(bookId);

            if (b == null || !m.borrowed.contains(b))
                throw new InvalidReturnException("Invalid return attempt!");

            b.available = true;
            m.borrowed.remove(b);
            double fee = calculateLateFee(lateDays);
            log.println("Returned: " + b.title + " by " + m.name + " | Late fee: ₹" + fee);
            log.flush();

            System.out.println("Book returned successfully. Late fee: ₹" + fee);
        }

        public double calculateLateFee(int days) {
            return days > 0 ? days * 2.0 : 0.0;
        }

        public void showMenu() throws Exception {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n=== Library Menu ===");
                System.out.println("1. Add Book");
                System.out.println("2. Add Member");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1 -> {
                        System.out.print("Book ID: "); int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Title: "); String title = sc.nextLine();
                        System.out.print("Author: "); String author = sc.nextLine();
                        addBook(new Book(id, title, author));
                        System.out.println("Book added!");
                    }
                    case 2 -> {
                        System.out.print("Member ID: "); int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: "); String name = sc.nextLine();
                        addMember(new Member(id, name));
                        System.out.println("Member added!");
                    }
                    case 3 -> {
                        System.out.print("Book ID: "); int bid = sc.nextInt();
                        System.out.print("Member ID: "); int mid = sc.nextInt();
                        issueBook(bid, mid);
                        System.out.println("Book issued!");
                    }
                    case 4 -> {
                        System.out.print("Book ID: "); int bid = sc.nextInt();
                        System.out.print("Member ID: "); int mid = sc.nextInt();
                        System.out.print("Late days: "); int days = sc.nextInt();
                        try {
                            returnBook(bid, mid, days);
                        } catch (InvalidReturnException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 5 -> {
                        log.close();
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        }
    }
    public class LibraryManagementSystem {
        public static void main(String[] args) {
            try {
                Library lib = new Library();
                lib.showMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


