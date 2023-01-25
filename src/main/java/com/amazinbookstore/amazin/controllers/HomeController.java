package com.amazinbookstore.amazin.controllers;

import com.amazinbookstore.amazin.dtos.CartDto;
import com.amazinbookstore.amazin.entities.Book;
import com.amazinbookstore.amazin.repositories.BookRepository;
import com.amazinbookstore.amazin.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartService cartService;


    @GetMapping("/")
    public String getBooks(Model model){
        Iterable<Book> bookList = bookRepository.findAll();

        model.addAttribute("books", bookList);

        return "index";
    }

    @GetMapping("/cart")
    public String getCartItem(Model model, Long userId){

        List<CartDto> cartItems = cartService.getAllCartByUserId(2l);
        if (cartItems.size() > 0){
            model.addAttribute("hasBooks", true);
        }else{
            model.addAttribute("hasBooks", false);
        }
        model.addAttribute("cartItems", cartItems);

        return "cart";
    }
}
