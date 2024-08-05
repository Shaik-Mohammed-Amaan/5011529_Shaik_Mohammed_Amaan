package com.library;

import com.library.model.Book;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService obj = (BookService) context.getBean("bookService");
        obj.getBooks();
        obj.getBookById(123);
        obj.addBook(new Book(130,"Wings of Fire","Abdul Kalam"));
        obj.updateBook(new Book(130,"Wings of Fire","A.P.J. Abdul Kalam"));
        obj.deleteBook(130);
    }
}
