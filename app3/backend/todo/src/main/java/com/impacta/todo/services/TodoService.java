package com.impacta.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impacta.todo.domain.Todo;
import com.impacta.todo.repositories.TodoRepository;
import com.impacta.todo.services.exception.ObjectNotFound;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public Todo create(Todo todo) {
		return todoRepository.save(todo);
	}

	public List<Todo> findAllOpen() {
		return todoRepository.findAllOpen();
	}

	public List<Todo> findAllClosed() {
		return todoRepository.findAllClosed();
	}

	public Todo findById(Integer id) {
		return todoRepository.findById(id).orElseThrow(() -> new ObjectNotFound("Objeto não encontrado " + id));
	}

	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Optional<Todo> deleteById(Integer id) {
		Optional<Todo> todo = todoRepository.findById(id);
		todoRepository.deleteById(id);
		return todo;

	}

	public Todo update(Integer id, Todo todo) {
		Todo newTodo = todoRepository.findById(id).orElse(null);
		newTodo.setTitulo(todo.getTitulo());
		newTodo.setDescricao(todo.getDescricao());
		newTodo.setDataParaFinalizar(todo.getDataParaFinalizar());
		newTodo.setFinalizado(todo.getFinalizado());
		return todoRepository.save(newTodo);
	}

}
