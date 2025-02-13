package com.example.library_manager.controller;


import com.example.library_manager.domain.Book;
import com.example.library_manager.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/books")
@NoArgsConstructor
@AllArgsConstructor
public class BookController {
    private BookService service;

    @GetMapping
    public List<Book> listAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> listById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Book save(@RequestBody @Valid Book book) {
        return service.saveData(book);
    }
}
