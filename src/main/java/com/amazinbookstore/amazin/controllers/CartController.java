package com.amazinbookstore.amazin.controllers;

import com.amazinbookstore.amazin.dtos.CartDto;
import com.amazinbookstore.amazin.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("api/v1/carts/user/{userId}")
    public List<CartDto> getCartsByUser(@PathVariable Long userId){
        return cartService.getAllCartByUserId(userId);
    }
}
