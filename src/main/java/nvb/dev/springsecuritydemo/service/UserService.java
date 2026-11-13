package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.dto.CreateUserRequest;
import nvb.dev.springsecuritydemo.dto.CreateUserResponse;

public interface UserService {

    CreateUserResponse registerUser(CreateUserRequest createUserRequest);

}
