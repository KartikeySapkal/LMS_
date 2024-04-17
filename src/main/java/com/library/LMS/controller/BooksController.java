package com.library.LMS.controller;

import com.library.LMS.entity.Books;
import com.library.LMS.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BooksController {

    private final BooksRepository bookRepo;

    @Autowired
    public BooksController(BooksRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @GetMapping({"/list", "/"})
    public String showAllBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "list-books";
    }

    @GetMapping("/addBookForm")
    public String addBookForm(Model model) {
        model.addAttribute("newBook", new Books());
        return "add-book-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("newBook") Books newBook) {
        bookRepo.save(newBook);
        return "redirect:/list";
    }

    @GetMapping("/updateBookForm/{id}")
    public String updateBookForm(@PathVariable Long id, Model model) {
        Books book = bookRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("newBook", book);
        return "add-book-form";
    }
}
