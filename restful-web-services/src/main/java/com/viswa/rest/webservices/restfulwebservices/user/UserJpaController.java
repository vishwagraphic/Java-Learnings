package com.viswa.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viswa.rest.webservices.restfulwebservices.jpa.UserRepository;
import com.viswa.rest.webservices.restfulwebservices.posts.Posts;
import com.viswa.rest.webservices.restfulwebservices.posts.PostsRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {
	private UserDaoService service;
	
	private UserRepository userRepository;
	
	private PostsRepository postsRepository;

	
	public UserJpaController(UserDaoService service, UserRepository repository, PostsRepository postsRepository) {
		this.service = service;
		this.userRepository = repository;
		this.postsRepository = postsRepository;
	}



	@GetMapping("/jpa/users")
	public List<User> findAllUsers(){
		List<User> allUsers = userRepository.findAll();
		
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
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> findOneUser(@PathVariable int id){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id){
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Posts> retrievePostsforUsers(@PathVariable int id){
		Optional<User> user=userRepository.findById(id);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user){
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(savedUser.getId())
												  .toUri();
		return ResponseEntity.created(location).build();
	}
	

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> addPostToUser(@PathVariable int id, @Valid @RequestBody Posts posts){
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("id:"+id);
		}
		
		
		posts.setUser(user.get());
		
		@Valid Posts savePosts = postsRepository.save(posts);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(savePosts.getId())
				  .toUri();
		return ResponseEntity.created(location).build();
	}
}
