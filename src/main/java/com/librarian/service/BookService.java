package com.librarian.service;

import com.librarian.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public  List<Book> getBooks() {
        Book b = new Book("ksiazka", "sss", 1L);
     return List.of(b);
    }
}
