package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.entity.UserroleEnum;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User save(User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserrole( UserroleEnum.ROLE_USER);
		userRepository.save(user);
		return user;
	}
	
	
	public Iterable<User> getAll(){
		return userRepository.findAll();
	}
	
	
	public void delete(String id){
		userRepository.delete(Integer.parseInt(id));
	}
		
	public User findOneUser(String id){
		return userRepository.findOne(Integer.parseInt(id));
	}
	 
}
