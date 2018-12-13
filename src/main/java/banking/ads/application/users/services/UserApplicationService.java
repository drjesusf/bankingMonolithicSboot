package banking.ads.application.users.services;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banking.ads.security.JwtTokenProvider;
import banking.ads.security.Role;
import banking.ads.api.enumeration.RequestBodyType;
import seedWork.Notification;
import banking.ads.application.users.dtos.UserAuthDto;
import banking.ads.application.users.dtos.UserClaimDto;
//import banking.common.infrastructure.security.Hashing;
import banking.ads.application.users.dtos.UserDto;
import banking.ads.domain.users.entities.User;
import banking.ads.domain.users.entities.UserClaim;
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
	
	public UserDto create(UserDto userDto) throws Exception{
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
	
	private Notification createValidation(UserDto userDto) throws Exception{
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

	public UserAuthDto validateUser(UserDto userDto) throws Exception{
		UserAuthDto userAuthDto = new UserAuthDto();
		User authUser = null;
		authUser = this.userRepository.getByName(userDto.getName());
		if (authUser == null) {
			return userAuthDto;
			
		}		
		//if (!Hashing.verifyHash(userDto.getPassword(), authUser.getPassword())) {
		//	return userAuthDto;
		//}
		userAuthDto = this.buildUserAuthDto(authUser);
		return userAuthDto;
	}

	private List<UserClaimDto> getUserClaims(User authUser) throws Exception {
		List<UserClaim> claims = this.userClaimRepository.findByUserId(authUser.getId());
		return mapper.map(claims, new TypeToken<List<UserClaimDto>>() {}.getType());
	}
	
	private UserAuthDto buildUserAuthDto(User authUser) throws Exception {
		UserAuthDto userAuthDto = new UserAuthDto();
		userAuthDto.setId(authUser.getId());
		userAuthDto.setName(authUser.getUserName());
		userAuthDto.setAuthenticated(true);
		userAuthDto.setBearerToken(new UUID(0L, 0L).toString());
		List<UserClaimDto> claims = this.getUserClaims(authUser);
		userAuthDto.setClaims(claims);
		//userAuthDto.setBearerToken(jwtTokenProvider.createToken(userAuthDto, ));
		return userAuthDto;
	}
	
	

}
