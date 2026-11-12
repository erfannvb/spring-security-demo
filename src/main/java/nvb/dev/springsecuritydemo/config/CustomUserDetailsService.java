package nvb.dev.springsecuritydemo.config;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.Person;
import nvb.dev.springsecuritydemo.repository.PersonRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    @Override
    public @NonNull UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Person person = personRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(person.getRole()));

        return new User(
                person.getEmail(),
                person.getPassword(),
                authorities
        );
    }
}
