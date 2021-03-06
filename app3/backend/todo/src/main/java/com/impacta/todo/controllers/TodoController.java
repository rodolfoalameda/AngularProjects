package com.impacta.todo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.impacta.todo.domain.Todo;
import com.impacta.todo.services.TodoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		return ResponseEntity.ok(todoService.findById(id));
	}

	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> findAllOpen() {
		return ResponseEntity.ok(todoService.findAllOpen());
	}

	@GetMapping(value = "/closed")
	public ResponseEntity<List<Todo>> findAllClosed() {
		return ResponseEntity.ok(todoService.findAllClosed());
	}

	@GetMapping(value = "")
	public ResponseEntity<List<Todo>> findAll() {
		return ResponseEntity.ok(todoService.findAll());
	}

	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo todo) {
		return ResponseEntity.ok(todoService.create(todo));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Optional<Todo>> deleteById(@PathVariable Integer id) {
		return ResponseEntity.ok(todoService.deleteById(id));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
		return ResponseEntity.ok(todoService.update(id, todo));
	}

}
