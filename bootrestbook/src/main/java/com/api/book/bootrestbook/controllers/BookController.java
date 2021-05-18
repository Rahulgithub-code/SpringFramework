package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller for non-rest use
//@RestController for REST API
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    // handlers
    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // @GetMapping is adavance version of @RequestMapping
    // @GetMapping("/books")
    // public List<Book> getBook(){
    // return bookService.getAllBooks();
    // }

    // @GetMapping("/book/{id}")
    // public Book getBookById(@PathVariable("id") int id) {
    // return bookService.getBookById(id);
    // }

    // @PostMapping("/book")
    // public Book addBook(@RequestBody Book book) {
    // this.bookService.addBook(book);
    // return book;
    // }

    // @DeleteMapping("/book/{id}")
    // public void deleteBookBuId(@PathVariable("id") int id) {
    // this.bookService.deleteBookById(id);
    // }

    // @PutMapping("/book/{id}")
    // public void updatebookById(@PathVariable("id") int id, @RequestBody Book
    // book) {
    // bookService.updatebookById(id, book);
    // }

    // Handling HttpStatus code while creating REST API
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBook() {
        List<Book> list = bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(book));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBookBuId(@PathVariable("id") int id) {
        try {
            this.bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updatebookById(@PathVariable("id") int id, @RequestBody Book book) {
        try {
            bookService.updatebookById(id, book);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
