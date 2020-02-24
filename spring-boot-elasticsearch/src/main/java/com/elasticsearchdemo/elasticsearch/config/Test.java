package com.elasticsearchdemo.elasticsearch.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.elasticsearchdemo.elasticsearch.bean.Book;
import com.github.javafaker.Faker;

public class Test {
	public static void main(String args[]){
			RestTemplate rt = new RestTemplate();
	        rt.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	        rt.getMessageConverters().add(new StringHttpMessageConverter());
	        Map<Integer, String> bookMap = new HashMap<Integer, String>();
	        for (int i=0; i<500; i++){
	        String uri = new String("http://localhost:8080/books");
	        Book book = new Book();
	        Faker faker = new Faker();
	        com.github.javafaker.Book fakeBook = faker.book();
	        book.setTitle(fakeBook.title());
	        book.setAuthor(fakeBook.author());
	        book.setPrice((float)faker.number().randomDouble(2, 10, 1000));
	        Book returns = rt.postForObject(uri, book, Book.class, i);
	        bookMap.put((i+1), returns.getId());
        }
	       System.out.println("Books inserted: "+bookMap);
	}
}
