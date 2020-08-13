package com.cognizant.bloodbank.security;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.bloodbank.exception.UserAlreadyExistsException;
import com.cognizant.bloodbank.model.Role;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.UserRepository;



@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// System.err.println("HI THERE -"+username);
		Optional<User> user = userRepository.findByFirstname1(username);
		// System.err.println("hai");
		// System.err.println("HI THERE by "+user.toString());
		// System.err.println("HI THERE"+user.getName());

		if (user.get() == null) {
			throw new UsernameNotFoundException(username + " not found");
		} else {
			// System.err.println("HI THERE by "+user);
			// System.err.println("INside else");
			return new AppUser(user.get());
		}
	}

	@SuppressWarnings("unused")
	@Transactional
	public boolean signup(User user) throws UserAlreadyExistsException {
		Optional<User> newUser = userRepository.findByFirstname1(user.getFirstname());
		// System.err.println("User inside signup:{}"+user);
		if (newUser.isPresent()) {

			throw new UserAlreadyExistsException();

		} else {

			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

			Set<Role> roles = new HashSet<Role>();

			Role role = new Role(2, "ROLE_USER");

			roles.add(role);
			System.err.println(user);
			User newuser = new User(0, user.getFirstname(),user.getLastname(),user.getPassword(),user.getAge(),user.getWeight(),user.getEmail(),user.getContactnumber(),user.getBloodgroup(),user.getState(),user.getArea(),user.getGender(),user.getPincode(),roles);
				
			User test = userRepository.save(newuser);
			System.err.println(test.toString());

		}

		return false;

	}
}
