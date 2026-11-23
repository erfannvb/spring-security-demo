package nvb.dev.springsecuritydemo.config;

import nvb.dev.springsecuritydemo.exception.CustomAccessDeniedHandler;
import nvb.dev.springsecuritydemo.exception.CustomBasicAuthenticationEntryPoint;
import nvb.dev.springsecuritydemo.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@Profile(value = "!prod")
public class SecurityConfig {

    private static final String[] NON_SECURED_PATHS = new String[]{"/notices", "/contact", "/error", "/api/v1/user/**"};
    private static final String[] SECURED_PATHS = new String[]{"/myAccount", "/myBalance", "/myCard", "/myLoan"};
    private static final String[] CSRF_IGNORING_URLS = new String[]{"/contact", "/register"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();

        http.cors(corsConfig -> corsConfig.configurationSource(corsConfigurationSource()));

        http.securityContext(contextConfig ->
                contextConfig.requireExplicitSave(false));

        http.sessionManagement(sessionConfig -> sessionConfig
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        http.csrf(csrfConfig ->
                csrfConfig
                        .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                        .ignoringRequestMatchers(CSRF_IGNORING_URLS)
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
        http.addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);

        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers(SECURED_PATHS).authenticated()
                        .requestMatchers(NON_SECURED_PATHS).permitAll());

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(hbc ->
                hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));

        http.exceptionHandling(ehc ->
                ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);

        return urlBasedCorsConfigurationSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
