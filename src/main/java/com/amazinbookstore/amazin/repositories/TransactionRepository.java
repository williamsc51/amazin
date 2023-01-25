package com.amazinbookstore.amazin.repositories;

import com.amazinbookstore.amazin.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

        /*
            Spring Data 'JpaRepository' automate CRUD methods to create/read/update/delete a record
        */
}