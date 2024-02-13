package com.pavan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pavan.model.Todo;
@Service
public interface TodoService {
	
	
    List<Todo> getAllTodos();

    Optional<Todo> getTodoById(Long id);
    
    
  //ADDING --N POST
    Todo addTodo(Todo todo);

    Todo updateTodo(Long id, Todo updatedTodo);

    void deleteTodo(Long id);

    Todo completeTodo(Long id);

    Todo uncompleteTodo(Long id);
}
