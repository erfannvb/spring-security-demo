package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.dto.CreateUserRequest;
import nvb.dev.springsecuritydemo.dto.CreateUserResponse;
import nvb.dev.springsecuritydemo.model.UserEntity;
import nvb.dev.springsecuritydemo.repository.UserRepository;
import nvb.dev.springsecuritydemo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        String hashedPassword = passwordEncoder.encode(createUserRequest.password());

        UserEntity user = UserEntity.builder()
                .username(createUserRequest.username())
                .password(hashedPassword)
                .role(createUserRequest.role())
                .build();

        UserEntity savedUser = userRepository.save(user);
        return new CreateUserResponse(savedUser.getUsername(), savedUser.getRole());
    }
}
