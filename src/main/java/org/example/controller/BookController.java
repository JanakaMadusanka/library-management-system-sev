package org.example.controller;

import org.example.dto.Book;
import org.example.entity.BookEntity;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    @Autowired
    BookService service;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping("/get")
    public Iterable<BookEntity> getBooks(){
        return service.getBooks();
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteBook(@PathVariable Long id){
        service.deleteBook(id);
        return "Deleted";
    }
    @GetMapping("search/{id}")
    public Book getBookById(@PathVariable Long id){
        return service.getBookById(id);
    }
}
