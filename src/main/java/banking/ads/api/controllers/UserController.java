package banking.ads.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import banking.ads.security.JwtTokenProvider;
import banking.ads.security.Role;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		if(user == null) return "";
		String url = user.getEmail() + " Hello;";
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.ROLE_ADMIN);
		String token = jwtTokenProvider.createToken(user.getEmail(),roles);
		return token;
	}
}
