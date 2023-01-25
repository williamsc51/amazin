package com.amazinbookstore.amazin.repositories;

import com.amazinbookstore.amazin.entities.Cart;
import com.amazinbookstore.amazin.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource //allow spring data rest to expose this as an endpoint
public interface CartRepository extends CrudRepository<Cart, Long> {

        /*
            Spring Data 'JpaRepository' automate CRUD methods to create/read/update/delete a record
            Spring Data Rest uses this repository to expose rest endpoints
        */
        public List<Cart> findAllByUserEquals(User user);

        @Override
        @RestResource(exported = false)
        Iterable findAll();
}
