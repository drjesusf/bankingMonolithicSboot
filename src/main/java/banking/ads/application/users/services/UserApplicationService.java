package banking.ads.application.users.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.ads.security.JwtTokenProvider;
import banking.ads.api.enumeration.RequestBodyType;
import seedWork.Notification;
//import banking.common.infrastructure.security.Hashing;
import banking.ads.application.users.dtos.UserDto;
import banking.ads.domain.users.entities.User;
import banking.ads.domain.users.contracts.IUserRepository;
import banking.ads.domain.users.contracts.IUserClaimRepository;

@Service
public class UserApplicationService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IUserClaimRepository userClaimRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	public UserDto create(UserDto userDto) {
		Notification notification = this.createValidation(userDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
		//String hashPassword = Hashing.hash(userDto.getPassword());
		//userDto.setPassword(hashPassword);
		User user = mapper.map(userDto, User.class);
		user = userRepository.save(user);
		userDto = mapper.map(user, UserDto.class);
        return userDto;
    }
	
	private Notification createValidation(UserDto userDto) {
		Notification notification = new Notification();
		if (userDto == null || userDto.getName().equals(RequestBodyType.INVALID.toString())) {
			notification.addError("Invalid JSON data in request body.");
		}
		User user = userRepository.getByName(userDto.getName().trim());
		if (user != null) {
			notification.addError("User name is already registered");
		}
		return notification;
	}

}
