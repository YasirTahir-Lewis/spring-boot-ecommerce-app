package com.yasir.user.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yasir.user.service.entity.User;

//@Service
public interface UserService {
	
	List<User> getAllUsers();
	User addUser(User user);
	User getUserById(Long id);
	User updateUser(User user);
	void deleteUser(Long id);

}
