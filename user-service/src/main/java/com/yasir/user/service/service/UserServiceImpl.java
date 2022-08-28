package com.yasir.user.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yasir.user.service.entity.User;
import com.yasir.user.service.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

//	@SuppressWarnings("static-access")
//	public User updateUser(User user) {
//		Optional<User> optional = userRepository.findById(user.getId());
//		if (optional.isPresent()) {
//			User newUser = optional.get();
//			newUser.builder()
////				.name(user.getName())
//				.userName(user.getUserName())
//				.password(user.getPassword())
////				.addresses(user.getAddresses())
//				.phoneNumber(user.getPhoneNumber())
//				.email(user.getEmail());
//			newUser = userRepository.save(newUser);
//		}
//		return user;
//	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);	
	}
	
	
}
