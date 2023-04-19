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

//@RestController
public class TodoResource {

	private TodoService todoService;
	
	
	
	public TodoResource(TodoService todoService) {
		super();
		this.todoService = todoService;
	}



	@GetMapping("/users/{username}/todos")
	public List<Todo> retreiveTodos(@PathVariable String username){
		return todoService.findByUserName(username);
		
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retreiveTodo(@PathVariable String username, @PathVariable int id){
		return todoService.findById(id);
		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo addTodo(@PathVariable String username, @RequestBody Todo todo){
		Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return createdTodo;
		
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username, @RequestBody Todo todo){
		todoService.updateTodo(todo);
		return todo;
		
	}
}
