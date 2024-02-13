package com.pavan.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.model.Todo;

//@Repository   it is not required bcs it is already present in simple jpa repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // You can add custom query methods if needed
}


