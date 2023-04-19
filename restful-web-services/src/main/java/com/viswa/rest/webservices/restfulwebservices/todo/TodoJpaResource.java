package com.viswa.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoJpaResource {

	private TodoService todoService;
	
	private TodoRepository todoRepository;
	
	public TodoJpaResource(TodoService todoService, TodoRepository todoRepository) {
		super();
		this.todoService = todoService;
		this.todoRepository = todoRepository;
	}



	@GetMapping("/users/{username}/todos")
	public List<Todo> retreiveTodos(@PathVariable String username){
		return todoRepository.findByUsername(username);
		
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retreiveTodo(@PathVariable String username, @PathVariable int id){
		return todoRepository.findById(id).get();
		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
		todoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo addTodo(@PathVariable String username, @RequestBody Todo todo){
		todo.setUsername(username);
		todo.setId(null);
		/*
		 * Todo createdTodo = todoService.addTodo(username, todo.getDescription(),
		 * todo.getTargetDate(), todo.isDone()); return createdTodo;
		 */
		return todoRepository.save(todo);
		
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo){
		todoRepository.save(todo);
		return todo;
		
	}
}
