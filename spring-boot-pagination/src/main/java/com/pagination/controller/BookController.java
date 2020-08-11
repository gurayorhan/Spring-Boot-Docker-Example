package com.pagination.controller;

import com.pagination.model.Book;
import com.pagination.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public Page<Book> pagination(@RequestParam Integer pageSize,@RequestParam Integer page){
        Pageable pageable = PageRequest.of(page,pageSize);
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/Page")
    public Page<Book> pagination(Pageable pageable){
        // page ve size olarak requestparam istenir otomatik. sort değişkeni ekleyip parametre verirsek sıralayıp gönderir.
        return bookRepository.findAll(pageable);
    }

    @GetMapping("/Slice")
    public Slice<Book> slice(Pageable pageable){
        // page ve size olarak requestparam istenir otomatik. sort değişkeni ekleyip parametre verirsek sıralayıp gönderir.
        // daha performanslı çalışmaktadır.
        return bookRepository.findAll(pageable);
    }

}
