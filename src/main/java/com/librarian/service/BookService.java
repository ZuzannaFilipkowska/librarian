package com.librarian.service;

import com.librarian.model.Book;
import com.librarian.model.User;
import com.librarian.repository.BookRepository;
import com.librarian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Autowired
    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    public void reserveBook(Book book) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        User userRef = userRepository.findUserByName(name);

        final Optional<Book> bookInDb = bookRepository.findById(book.getId());

        if (bookInDb.isPresent()) {
            if (book.getVersion() != bookInDb.get().getVersion()) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Book was changed");
            }
            book.setUser(userRef);
            book.setReservationDate(LocalDate.now());
            book.setStatus("RESERVED");
            bookRepository.save(book);
        }

    }
    public void bookBook(Book book) {

        User userRef = userRepository.findUserByName(book.getUser().getName());

        final Optional<Book> bookInDb = bookRepository.findById(book.getId());

        if (bookInDb.isPresent()) {
            if (book.getVersion() != bookInDb.get().getVersion()) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Book was changed");
            }
            book.setUser(userRef);
            book.setBorrowingDate(LocalDate.now());
            book.setStatus("BORROWED");
            bookRepository.save(book);
        }

    }

    public void returnBook(Book book) {
        final Optional<Book> bookInDb = bookRepository.findById(book.getId());

        if (bookInDb.isPresent()) {
            if (book.getVersion() != bookInDb.get().getVersion()) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Book was changed");
            }
            book.setBorrowingDate(null);
            book.setReservationDate(null);
            book.setStatus("AVAILABLE");
            bookRepository.save(book);
        }

    }

    public List<Book> findMatchingBooks(String pattern) {
        return this.bookRepository.findAllByTitleContainsIgnoreCaseOrAuthorContainingIgnoreCase(pattern, pattern);
    }
}
