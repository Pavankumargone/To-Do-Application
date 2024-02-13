
package com.pavan.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.model.Todo;
import com.pavan.repository.TodoRepository;

import lombok.AllArgsConstructor;

// You can add additional validation or business logic here in session
@AllArgsConstructor  // used for constructor injection of beans
@Service
public class TodoServiceImpl implements TodoService {
//@Autowired  used for automatic injection of beans
	private TodoRepository todoRepository;

	@Override
	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Optional<Todo> getTodoById(Long id) {
		return todoRepository.findById(id);
	}

	@Override
	public Todo addTodo(Todo todo) {

		return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(Long id, Todo updatedTodo) {

		Optional<Todo> existingTodo = todoRepository.findById(id);
		if (existingTodo.isPresent()) {
			updatedTodo.setId(id);
			return todoRepository.save(updatedTodo);
		} else {

			return null;
		}
	}

	@Override
	public void deleteTodo(Long id) {

		todoRepository.deleteById(id);
	}

	@Override
	public Todo completeTodo(Long id) {

		Optional<Todo> todoOptional = todoRepository.findById(id);
		if (todoOptional.isPresent()) {
			Todo todo = todoOptional.get();
			todo.setCompleted(true);
			return todoRepository.save(todo);
		} else {

			return null;
		}
	}

	@Override
	public Todo uncompleteTodo(Long id) {

		Optional<Todo> todoOptional = todoRepository.findById(id);
		if (todoOptional.isPresent()) {
			Todo todo = todoOptional.get();
			todo.setCompleted(false);
			return todoRepository.save(todo);
		} else {

			return null;
		}
	}

}
