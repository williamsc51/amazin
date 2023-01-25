package com.amazinbookstore.amazin.dtos;

import com.amazinbookstore.amazin.entities.Cart;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class CartDto implements Serializable {

    private Long id;

    private Integer quantity;

    private UserDto userDto;

    private BookDto bookDto;

    public CartDto(Cart cart) {
        if (cart.getId() != null){
            this.id = cart.getId();
        }
        if (cart.getQuantity() != null){
            this.quantity = cart.getQuantity();
        }
        if (cart.getBook() != null){
            this.bookDto = new BookDto(cart.getBook());
        }
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("book")
    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
