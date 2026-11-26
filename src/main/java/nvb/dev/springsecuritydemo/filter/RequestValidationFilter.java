package nvb.dev.springsecuritydemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class RequestValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (header != null) {
            header = header.trim();
            if (StringUtils.startsWithIgnoreCase(header, "Basic ")) {
                byte[] base64Token = header.substring(6).getBytes(StandardCharsets.UTF_8);
                byte[] decodedToken = Base64.getDecoder().decode(base64Token);

                String token = new String(decodedToken, StandardCharsets.UTF_8);

                int delimiter = token.indexOf(":");
                if (delimiter == -1)
                    throw new BadCredentialsException("Invalid basic authentication token.");

                String username = token.substring(0, delimiter);
                if (username.toLowerCase().contains("test")) {
                    httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }
            }
        }


        chain.doFilter(request, response);
    }
}
