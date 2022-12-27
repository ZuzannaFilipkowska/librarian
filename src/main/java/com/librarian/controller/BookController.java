package com.librarian.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
//
//    private final BookService bookService;
//
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping("/books")
    public String findAllBooks() {
        return new String("hello");
    }
}
