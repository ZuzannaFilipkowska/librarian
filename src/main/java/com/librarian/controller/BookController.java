package com.librarian.controller;


import com.librarian.model.Book;
import com.librarian.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public List<Book> findAllBooks() {
        return bookService.getBooks();
    }
}
