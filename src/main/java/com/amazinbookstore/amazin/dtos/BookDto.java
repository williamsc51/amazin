package com.amazinbookstore.amazin.dtos;

import com.amazinbookstore.amazin.entities.Book;
import com.amazinbookstore.amazin.entities.Cart;
import com.amazinbookstore.amazin.entities.Transaction;
import com.amazinbookstore.amazin.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto implements Serializable {
    private Long id;

    private String title;

    private String author;

    private Long isbn;

    private Double price;

    private String category;

    private User user;

    private Set<Cart> carts;

    private Collection<Transaction> transactions;

    public BookDto(Book book){
        if (book.getId() != null){
            this.id = book.getId();
        }
        if (book.getTitle() != null){
            this.title = book.getTitle();
        }
        if (book.getAuthor() != null){
            this.author = book.getAuthor();
        }
        if (book.getIsbn() != null){
            this.isbn = book.getIsbn();
        }
        if (book.getPrice() > 0.0){
            this.price = book.getPrice();
        }
        if (book.getCategory() != null){
            this.category = book.getCategory();
        }
    }
}
