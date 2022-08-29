package com.yasir.user.service.controller;

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

import com.yasir.user.service.entity.User;
import com.yasir.user.service.service.UserService;
import com.yasir.user.service.service.UserServiceImpl;


@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}

	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	@PutMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
