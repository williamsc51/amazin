package com.amazinbookstore.amazin.services;

import com.amazinbookstore.amazin.dtos.CartDto;
import com.amazinbookstore.amazin.entities.Cart;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {
    @Transactional
    public List<CartDto> getAllCartByUserId(Long userId);
}
