package projeto.lab.toDoLab.configuration;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import projeto.lab.toDoLab.repository.UserRepository;
import projeto.lab.toDoLab.service.TokenService;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {


    @Autowired
    private TokenService tokenService;


    @Autowired
    private UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        var token = recoverToken(request);
        if(token != null){
            var username = tokenService.tokenValidator(token);
            UserDetails user = userRepository.findByUsername(username);
            var authentication = new UsernamePasswordAuthenticationToken(user, null,  user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response); // filtro interno utilizando request e response
    }



    public String recoverToken(HttpServletRequest request){
        var authheader = request.getHeader("Authorization");
        if(authheader == null) return null;
        return authheader.replace("Bearer", "");
    }
}
