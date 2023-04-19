package com.viswa.learnspringsecurity.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<Todo> TODOS_LIST = List.of(new Todo("Viswa", "Learn AWS"), new Todo("Akshay", "Learn Java"));

	@GetMapping("/todos")
	
	public List<Todo> retreiveTodos() {
		return TODOS_LIST;
	}
	
	@GetMapping("/users/{username}/todos")
	@PreAuthorize("hasRole('USER') and #username == authentication.username)")
	//@PostAuthorize("returnObject.username == 'Viswa'")
	public Todo retreiveTodosForSpecificUser(@PathVariable String username) {
		return TODOS_LIST.get(0);
	}
	
	@PostMapping("/users/{username}/todos")
	public void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
		logger.info("Create {} for {}", todo, username);
	}
	
	
}

record Todo(String username, String description) {}

