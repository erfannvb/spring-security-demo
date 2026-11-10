package nvb.dev.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class SecurityConfig {

    private static final String[] NON_SECURED_PATHS = new String[]{"/notices", "/contact", "/error"};
    private static final String[] SECURED_PATHS = new String[]{"/myAccount", "/myBalance", "/myCard", "/myLoan"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers(SECURED_PATHS).authenticated()
                        .requestMatchers(NON_SECURED_PATHS).permitAll());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails adminUser = User
                .withUsername("admin")
                .password("{bcrypt}$2a$12$py9GQUK6FsO7lQO9c4Fp6efFfNY4swoFNBpO1H3eIfx3kZa2l.4Ee")
                .authorities("admin")
                .build();

        UserDetails normalUser = User
                .withUsername("user")
                .password("{noop}753357")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(adminUser, normalUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
