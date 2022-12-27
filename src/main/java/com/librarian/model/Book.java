package com.librarian.model;

import lombok.Data;

@Data
public class Book {
    private final String name;
    private final String author;
    private final Long id;
}
