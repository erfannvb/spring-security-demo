package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.dto.CreateUserRequest;

public interface UserService {

    void registerUser(CreateUserRequest createUserRequest);

}
