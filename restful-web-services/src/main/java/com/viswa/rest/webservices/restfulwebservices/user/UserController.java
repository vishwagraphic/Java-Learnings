package com.viswa.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import jakarta.validation.Valid;

//@RestController
public class UserController {
	private UserDaoService service;

	
	public UserController(UserDaoService service) {
		this.service = service;
	}



	@GetMapping("/users")
	public List<User> findAllUsers(){
		List<User> allUsers = service.findAll();
		
		/*
		 * MappingJacksonValue mappingJackonValue = new MappingJacksonValue(allUsers);
		 * 
		 * 
		 * SimpleBeanPropertyFilter filter =
		 * SimpleBeanPropertyFilter.filterOutAllExcept("id", "name"); FilterProvider
		 * ifilters = new SimpleFilterProvider().addFilter("SomeUsers", filter );
		 * mappingJackonValue.setFilters(ifilters); return mappingJackonValue;
		 */
		 
		return allUsers;
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> findOneUser(@PathVariable int id){
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteUser(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
		User savedUser = service.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(savedUser.getId())
												  .toUri();
		return ResponseEntity.created(location).build();
	}
}
