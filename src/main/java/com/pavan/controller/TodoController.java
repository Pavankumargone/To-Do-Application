package com.pavan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.model.Todo;
import com.pavan.service.TodoService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")     //http://localhost:7713/api/todo
@AllArgsConstructor
public class TodoController {

	// @Autowired
	private TodoService todoService;

	@GetMapping
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {

		Optional<Todo> todoOptional = todoService.getTodoById(id);
		return todoOptional.map(todo -> ResponseEntity.ok(todo)).orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		Todo addedTodo = todoService.addTodo(todo);
		return new ResponseEntity<>(addedTodo, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
		Todo todo = todoService.updateTodo(id, updatedTodo);
		if (todo != null) {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
		System.out.println("deleted scssfully");
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("{id}/complete")
	public ResponseEntity<Todo> completeTodo(@PathVariable Long id) {
		Todo todo = todoService.completeTodo(id);
		if (todo != null) {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("{id}/incomplete")
	public ResponseEntity<Todo> uncompleteTodo(@PathVariable Long id) {
		Todo todo = todoService.uncompleteTodo(id);
		if (todo != null) {
			return new ResponseEntity<>(todo, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
