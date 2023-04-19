package com.viswa.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;


@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		users.add(new User(userCount++, "Viswa", LocalDate.now().minusYears(42).minusMonths(6).minusDays(5)));
		users.add(new User(userCount++, "Akshay", LocalDate.now().minusYears(8).minusDays(4)));
		users.add(new User(userCount++, "Lakshmi", LocalDate.now().minusYears(38).minusMonths(6).minusDays(5)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	
	public User findOne(int id) { 
		 
	  Predicate<? super User> predicate = user -> user.getId() == id;
	  return users.stream().filter(predicate ).findFirst().orElse(null); 
	}


	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setId(userCount++);
		users.add(user);
		return user;
	}
	
	public void deleteUser(int id) {
		
		Predicate<? super User> predicate = user -> user.getId() == id;
		  users.removeIf(predicate);
		
	}
	
	
	 
}
