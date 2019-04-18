package booktrade.api.config;

import booktrade.api.exception.UserNotFoundException;
import booktrade.api.exception.WrongPasswordException;
import booktrade.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();

        String password = authentication.getCredentials().toString();

        UserDetails user = userService.loadUserByUsername(email);

        if(user == null)
            throw new UserNotFoundException("User Not Found" + email);

        if(!passwordEncoder.matches(password,user.getPassword()))
            throw new WrongPasswordException();

        List<GrantedAuthority>  authorities = new ArrayList<>(user.getAuthorities());

        return new UsernamePasswordAuthenticationToken(email,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
