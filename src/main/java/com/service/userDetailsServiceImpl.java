package com.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;




import com.repository.UserRepository;

@Service("userDetailsService")
public class userDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserDetails loadUserByUsername(String login)	throws UsernameNotFoundException {
		if(login.equals("admin")){
			Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			return new User("admin", bCryptPasswordEncoder.encode("admin"), authorities);
		}
		
		com.entity.User user = null;
		
		user = userRepository.findOneByUsername(login);
		
		if (user == null) {
			return null;
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(user.getUserrole().toString()));
		return new User(String.valueOf(user.getId()), user.getPassword(), authorities);
	}
	
}
