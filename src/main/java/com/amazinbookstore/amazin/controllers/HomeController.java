package com.amazinbookstore.amazin.controllers;

import com.amazinbookstore.amazin.dtos.CartDto;
import com.amazinbookstore.amazin.entities.Book;
import com.amazinbookstore.amazin.entities.User;
import com.amazinbookstore.amazin.repositories.BookRepository;
import com.amazinbookstore.amazin.repositories.UserRepository;
import com.amazinbookstore.amazin.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CartService cartService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String getBooks(Model model){
        Iterable<Book> bookList = bookRepository.findAll();

        model.addAttribute("books", bookList);

        return "index";
    }

    @GetMapping("/cart")
    public String getCartItem(Model model, Principal principal){

        if(principal.getName() != null){
            Optional<User> user = userRepository.findByEmail(principal.getName());

            if (user.isPresent()){
                List<CartDto> cartItems = cartService.getAllCartByUserId(user.get().getId());

                if (cartItems.size() > 0){
                    model.addAttribute("hasBooks", true);
                    model.addAttribute("cartItems", cartItems);
                }else{
                    model.addAttribute("hasBooks", false);
                }

            }else{
                return null;
            }
        }else {
            return null;
        }

        return "cart";
    }
}
