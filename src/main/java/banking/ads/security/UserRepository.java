package banking.ads.security;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	public User findByUsername(String username) {
		User user = new User();
		user.setEmail("drjesusf@gmail.com");
		user.setPassword("123456");
		List<Role> roles = new ArrayList<Role>();
		roles.add(Role.ROLE_ADMIN);
		
		user.setRoles(roles);
		return user;
	}

}
