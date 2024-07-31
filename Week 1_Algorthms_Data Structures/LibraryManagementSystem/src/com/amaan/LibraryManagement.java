package com.amaan;

import java.util.Arrays;

public class LibraryManagement {

    private Book[] books;
    private int length;
    private static int i = 0;

    public LibraryManagement(int length) {
        this.length = length;
        books = new Book[this.length];
    }

    public void addBook(Book book) {
        books[i++] = book;
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < length; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, new BookTitleComparator());
        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }


}
