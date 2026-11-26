package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.dto.CreateUserRequest;
import nvb.dev.springsecuritydemo.dto.CreateUserResponse;
import nvb.dev.springsecuritydemo.dto.UserinfoDto;
import nvb.dev.springsecuritydemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<CreateUserResponse> registerUser(@RequestBody CreateUserRequest createUserRequest) {
        CreateUserResponse userResponse = userService.registerUser(createUserRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

    @GetMapping(path = "/info")
    public ResponseEntity<UserinfoDto> getUserInfo(Authentication authentication) {
        return ResponseEntity
                .ok(userService.getUserInfo(authentication));
    }

}
