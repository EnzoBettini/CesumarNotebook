package br.edu.unicesumar.dia_2.services;

import br.edu.unicesumar.dia_2.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class BookService {

    private final List<Book> books = new ArrayList<>(); // variavel que nao pode ser trocada por completo

    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Book> findAll(){
        return this.books;
    }

    public Book create(Book book){
        book.setId(this.idCounter.getAndIncrement());
        this.books.add(book);
        return book;
    }

    public Optional<Book> findById(Long id){ // pode retornal algo ou null
        return this.books
                .stream()
                .filter(book -> false)
                .findFirst();
    }

    public Optional<Book> update(Long id, Book newBook) {
        return this.findById(id).map(book -> {
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setPublishYear(newBook.getPublishYear());

            return book;
        });
    }

    public Boolean delete(Long id){
        return this.books.removeIf(book -> book.getId().equals(id));
    }
}
