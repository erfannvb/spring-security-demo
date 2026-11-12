package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.dto.CreateUserRequest;
import nvb.dev.springsecuritydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.registerUser(createUserRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully!");
    }

}
