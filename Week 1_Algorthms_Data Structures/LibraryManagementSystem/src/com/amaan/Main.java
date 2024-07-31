package com.amaan;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book(123, "Adventures of Tom Sawyer", "Mark Twain");
        Book book2 = new Book(124, "Alice in Wonderland", "Lewis Carrol");
        Book book3 = new Book(126, "Gulliver’s Travels", "Jonathan Swift");
        Book book4 = new Book(125, "A passage to India", "E.M.Forster");
        Book book5 = new Book(128, "Discovery of India", "Pandit Jawaharlal Nehru");

        LibraryManagement libraryManagement = new LibraryManagement(5);
        libraryManagement.addBook(book1);
        libraryManagement.addBook(book2);
        libraryManagement.addBook(book3);
        libraryManagement.addBook(book4);
        libraryManagement.addBook(book5);

        System.out.println("Linear Search");
        System.out.println(libraryManagement.linearSearchByTitle("Alice in Wonderland"));

        System.out.println("Binary Search");
        System.out.println(libraryManagement.binarySearchByTitle("A passage to India"));
    }
}
