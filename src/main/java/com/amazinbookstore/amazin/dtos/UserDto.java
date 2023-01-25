package com.amazinbookstore.amazin.dtos;

import com.amazinbookstore.amazin.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Contact contact;

    private Set<Cart> carts = new HashSet<>();

    private Set<Book> books = new HashSet<>();

    private Set<Transaction> transactions = new HashSet<>();

    public UserDto(User user) {
        if (user.getId() != null){
            this.id = user.getId();
        }
        if (user.getFirstName() != null){
            this.firstName = user.getFirstName();
        }
        if (user.getLastName() != null){
            this.lastName = user.getLastName();
        }
        if (user.getEmail() != null){
            this.email = user.getEmail();
        }
        if (user.getPassword() != null){
            this.password = user.getPassword();
        }
        if (user.getContact() != null){
            this.contact = user.getContact();
        }
        if (user.getCarts() != null){
            this.carts = user.getCarts();
        }
        if (user.getBooks() != null){
            this.books = user.getBooks();
        }
        if (user.getTransactions() != null){
            this.transactions = user.getTransactions();
        }

    }
}
