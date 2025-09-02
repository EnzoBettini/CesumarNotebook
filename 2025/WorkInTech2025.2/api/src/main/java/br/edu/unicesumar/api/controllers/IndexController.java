package br.edu.unicesumar.api.controllers;

import br.edu.unicesumar.api.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class IndexController {

    private List<Book> books = new ArrayList<>();

    @PostMapping("/")
    public Book createBook(@RequestBody Book book) {
        this.books.add(book);
        return book;
    }

    @GetMapping("/")
    public List<Book> getBooks() {
        return this.books;
    }
}
