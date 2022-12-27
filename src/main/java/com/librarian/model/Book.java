package com.librarian.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(generator ="UUID")
    private UUID id = UUID.randomUUID();
    private String title;
    private String author;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate borrowingDate;
    @ManyToOne
    private User user;
//    @Timestamp
//    byte[] rowVersion;

}
