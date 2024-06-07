package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Repository.UserRepository;
import com.user.model.User;

@Service
public class UserService {

	@Autowired
    private UserRepository repository;
	
	
	public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getUser() {
        return repository.getAllUsers();
    }

    public User getUserById(int id) {
        return repository.findById(id);
    }

    public String deleteUser(int id) {
        repository.delete(id);
        return "user removed !! " + id;
    }

    public User updateUser(User user) {
       return repository.update(user);
    }
}
