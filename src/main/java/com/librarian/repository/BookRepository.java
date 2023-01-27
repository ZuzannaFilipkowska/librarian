package com.librarian.repository;

import com.librarian.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    List<Book> findAllByUser_NameAndStatusEqualsOrStatusEquals(String name, String status, String secondStatus);
    List<Book> findAllByStatusIs(String status);

    List<Book> findAllByTitleContainsIgnoreCaseOrAuthorContainingIgnoreCase(String pattern, String patternAuthor);
}
