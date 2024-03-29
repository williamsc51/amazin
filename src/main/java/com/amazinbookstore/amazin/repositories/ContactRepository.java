package com.amazinbookstore.amazin.repositories;

import com.amazinbookstore.amazin.entities.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource //allow spring data rest to expose this as an endpoint
public interface ContactRepository extends CrudRepository<Contact, Long> {

        /*
            Spring Data 'JpaRepository' automate CRUD methods to create/read/update/delete a record
            Spring Data Rest uses this repository to expose rest endpoints
        */
}