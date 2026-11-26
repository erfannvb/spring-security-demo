package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.dto.CreateUserRequest;
import nvb.dev.springsecuritydemo.dto.CreateUserResponse;
import nvb.dev.springsecuritydemo.dto.UserinfoDto;
import org.springframework.security.core.Authentication;

public interface UserService {

    CreateUserResponse registerUser(CreateUserRequest createUserRequest);

    UserinfoDto getUserInfo(Authentication authentication);

}
