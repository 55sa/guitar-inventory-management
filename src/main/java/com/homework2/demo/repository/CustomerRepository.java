package com.homework2.demo.repository;

import com.homework2.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {
    Customer findByUsername(String username);
}
