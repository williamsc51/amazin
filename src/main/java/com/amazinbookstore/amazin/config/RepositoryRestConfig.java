package com.amazinbookstore.amazin.config;

import com.amazinbookstore.amazin.entities.Book;
import com.amazinbookstore.amazin.entities.Cart;
import com.amazinbookstore.amazin.entities.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(User.class, Book.class, Cart.class);
    }
}
