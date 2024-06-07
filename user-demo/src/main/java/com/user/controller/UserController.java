package com.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping(path = "/api")
public class UserController {
	 @Autowired
	    private UserService service;
	 
	 	

	    @PostMapping("/users")
	    public ResponseEntity<User> addUser(@RequestBody User user) {
	    	User user1 = service.saveUser(user);
	    		    return new ResponseEntity<>(user1, HttpStatus.CREATED);
	    }

	    @GetMapping("/users")
	    public ResponseEntity<List<User>> findAllUsers() {
	    	List<User> users = service.getUser();
	    	if (users.isEmpty()) {
	    	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	    }

	    	    return new ResponseEntity<>(users, HttpStatus.OK);
	    	  }
	    


	    @GetMapping("/users/{id}")
	    public ResponseEntity<User> findUserById(@PathVariable int id) {
	    	User user = service.getUserById(id);

	        return new ResponseEntity<>(user, HttpStatus.OK);
	        
	    }

	    @PutMapping("/users")
	    public  ResponseEntity<User> updateUser(@RequestBody User user) {
	    	User user1 = service.updateUser(user);
	        return new ResponseEntity<>(service.saveUser(user1), HttpStatus.OK);
 
	    }

	    @DeleteMapping("/users/{id}")
	    public ResponseEntity<HttpStatus> deleteUser(@PathVariable int id) {
	         service.deleteUser(id);
	         return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	    }
}
