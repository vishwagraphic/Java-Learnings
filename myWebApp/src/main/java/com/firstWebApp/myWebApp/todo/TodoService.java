package com.firstWebApp.myWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	//private Logger logger = LoggerFactory.getLogger(getClass());
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(todosCount++, "Viswa", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(todosCount++, "Viswa", "Learn Java", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(todosCount++, "Viswa", "Learn FullStack", LocalDate.now().plusYears(2), false));
	}
	
	public List<Todo> findByUserName(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		var test = todos.stream().filter(predicate).toList();
		return test;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done){
		Todo todo = new Todo(todosCount++, username, description, targetDate, done);
		todos.add(todo);
	}
	
	public void deleteTodo(int id){
		
		Predicate<? super Todo> prdicate = todo -> todo.getId() == id;
		todos.removeIf(prdicate);
	}

	public Todo findById(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> prdicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(prdicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
	}

	

}
