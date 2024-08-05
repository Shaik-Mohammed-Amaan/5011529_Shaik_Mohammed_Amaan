package com.library;

import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //passing bean id
        BookService bookService = (BookService) context.getBean("bookService");
        //passing class name
        BookRepository bookRepository = context.getBean(BookRepository.class);
    }
}
