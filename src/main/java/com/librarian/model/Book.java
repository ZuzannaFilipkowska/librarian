package com.librarian.model;


//import jakarta.persistence.*;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "BOOK")
@Table(name = "BOOKS")
@Data
public class Book {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "BOOK_ID", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id = UUID.randomUUID();
    private String title;
    private String author;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingDate;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Version
    private int version;
}
