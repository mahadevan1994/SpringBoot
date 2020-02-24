/*package com.elasticsearchdemo.elasticsearch.dao;

import com.elasticsearchdemo.elasticsearch.bean.Book;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import reactor.core.publisher.Flux;

public interface ReactiveBookRepository extends ReactiveSortingRepository<Book, String>{
	Flux<Book> findByTitle(String title);
	Flux<Book> findByAuthor(String author);
}
*/