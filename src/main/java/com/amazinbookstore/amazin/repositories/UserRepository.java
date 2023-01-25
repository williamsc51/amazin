package com.amazinbookstore.amazin.repositories;

import com.amazinbookstore.amazin.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RepositoryRestResource //allow spring data rest to expose this as an endpoint
public interface UserRepository extends CrudRepository<User, Long> {
        /*
            Spring Data 'JpaRepository' automate CRUD methods to create/read/update/delete a record
            Spring Data Rest uses this repository to expose rest endpoints
        */
    public Optional<User> findByEmail(String email);

    @Override
    @RestResource(exported = false)
    Iterable findAll();
}