package com.api.book.bootrestbook.services;

import java.util.List;

import com.api.book.bootrestbook.Entities.Book;
import com.api.book.bootrestbook.dao.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Service or
@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    //private static List<Book> list = new ArrayList<>();

    static{
    //    list.add(new Book(101,"Java Complete Reference", "ABC"));
    //    list.add(new Book(102,"Head first to Java", "DEF"));
    //    list.add(new Book(103,"Think in Java", "XYZ"));
    }

    

    public List<Book> getAllBooks(){
        //return list;
        List<Book> listOfBook = (List<Book>) bookRepository.findAll();
        return listOfBook;
    }

    public Book getBookById(int id){
        Book book = null;
        try {
            //book = list.stream().filter(e->e.getId()==id).findFirst().get();
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    public void addBook(Book book){
        //list.add(book);
        bookRepository.save(book);
    }

    public void deleteBookById(int id){
        // list=list.stream().filter(e-> {
        //     if(e.getId()!=id){
        //         return true;
        //     }else{
        //         return false;
        //     }
        // }).collect(Collectors.toList());
        //list=list.stream().filter(e-> e.getId()!=id).collect(Collectors.toList());

        bookRepository.deleteById(id);
    }

    public void updatebookById(int id, Book book){
        //  list=list.stream().map(b -> {
        //     if(b.getId()==id){
        //         b.setAuthor(book.getAuthor());
        //         b.setTitle(book.getTitle());
        //     }
        //     return b;
        // }).collect(Collectors.toList());
        book.setId(id);
        bookRepository.save(book);
    }
    
    
}
