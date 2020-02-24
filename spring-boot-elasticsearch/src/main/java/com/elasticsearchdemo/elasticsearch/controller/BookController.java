package com.elasticsearchdemo.elasticsearch.controller;

import com.elasticsearchdemo.elasticsearch.bean.Book;
import com.elasticsearchdemo.elasticsearch.dao.BookDao;
//import com.elasticsearchdemo.elasticsearch.dao.ReactiveBookRepository;

import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @PostMapping
    public Book insertBook(@RequestBody Book book) throws Exception{
        return bookDao.insertBook(book);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getBookById(@PathVariable String id){
        return bookDao.getBookById(id);
    }
    
    @PutMapping("/{id}")
    public Map<String, Object> updateBookById(@RequestBody Book book, @PathVariable String id){
        return bookDao.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable String id){
         bookDao.deleteBookById(id);
    }
    
    /*@GetMapping("/byTitle/{title}")
    public Flux<Book> getBookByTitle(@PathVariable String title){
        return ReactiveBookRepository.findByTitle(title);
    }*/
}
