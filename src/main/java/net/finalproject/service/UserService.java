package net.finalproject.service;

import net.finalproject.models.User;
import net.finalproject.models.CustomOAuth2User;
import net.finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void processOAuthPostLogin(CustomOAuth2User customOAuth2User) {
		String username=customOAuth2User.getEmail();
		User existUser = repo.getUserByUsername(username);
		
		if (existUser == null) {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setEnabled(true);
			newUser.setFullName(customOAuth2User.getName());
			repo.save(newUser);
		}
		
	}

	public User getUserForEmail(String email){
		return repo.getUserByUsername(email);
	}
	
}
