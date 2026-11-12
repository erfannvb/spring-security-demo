package nvb.dev.springsecuritydemo.dto;

public record CreateUserRequest(String username,
                                String password,
                                String role) {
}
