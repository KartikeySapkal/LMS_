package com.library.LMS.controller;

import com.library.LMS.entity.Books;
import com.library.LMS.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BooksController {

    @Autowired
    private BooksRepository bookrepo;

    @GetMapping({"/","list"})
    public ModelAndView showBooks() {
        ModelAndView mav = new ModelAndView("list-books");
        List<Books> list = bookrepo.findAll();
        mav.addObject("Books",list);
        return mav;

    }


}
