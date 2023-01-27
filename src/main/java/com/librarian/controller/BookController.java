package com.librarian.controller;


import com.librarian.model.Book;
import com.librarian.repository.BookRepository;
import com.librarian.service.BookService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final BookService bookService;

    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("search")
    public List<Book> findMatchingBooks(@RequestParam String pattern) {
        return this.bookService.findMatchingBooks(pattern);
    }
    @GetMapping("/user")
    public List<Book> findUserBooks() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return this.bookRepository.findAllByUser_NameAndStatusEqualsOrStatusEquals(name, "BORROWED", "RESERVED");
    }

    @GetMapping("/reserved")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Book> findReservedBooks() {
        return this.bookRepository.findAllByStatusIs("RESERVED");
    }

    @GetMapping("/borrowed")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Book> findBorrowedBooks() {
        return this.bookRepository.findAllByStatusIs("BORROWED");
    }

    @Transactional
    @PutMapping
    public void reserveBook(@RequestBody final Book book) {
        this.bookService.reserveBook(book);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    @PutMapping("admin/book")
    public void bookBook(@RequestBody final Book book) {
        this.bookService.bookBook(book);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    @PutMapping("admin/return")
    public void returnBook(@RequestBody final Book book) {
        this.bookService.returnBook(book);
    }

    @Transactional
    @PutMapping("user/cancel")
    public void cancelReservation(@RequestBody final Book book) {
        this.bookService.returnBook(book);
    }


}

