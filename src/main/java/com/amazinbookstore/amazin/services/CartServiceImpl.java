package com.amazinbookstore.amazin.services;

import com.amazinbookstore.amazin.dtos.CartDto;
import com.amazinbookstore.amazin.entities.Book;
import com.amazinbookstore.amazin.entities.Cart;
import com.amazinbookstore.amazin.entities.User;
import com.amazinbookstore.amazin.repositories.CartRepository;
import com.amazinbookstore.amazin.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    public UserRepository userRepository;

    @Override
    @Transactional
    public List<CartDto> getAllCartByUserId(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            List<Cart> cartList = cartRepository.findAllByUserEquals(userOptional.get());
            return cartList.stream().map (cart -> new CartDto (cart)).collect (Collectors.toList());
        }

        return Collections.emptyList();
    }

    @Override
    public double cartTotal(List<CartDto> cartDto){

        double total = 0.0;

        for(var item : cartDto){
            total = total + item.getBookDto().getPrice();
        }

        return total;
    }
}
