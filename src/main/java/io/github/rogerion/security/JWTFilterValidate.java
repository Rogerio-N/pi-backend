package io.github.rogerion.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.github.rogerion.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTFilterValidate extends BasicAuthenticationFilter {

    public static final String HEADER_ATRIBUTE = "Authorization";
    public static final String ATRIBUTE_PREFIX = "Bearer ";

    public JWTFilterValidate(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        String atribute = request.getHeader(HEADER_ATRIBUTE);

        if(atribute == null){
            chain.doFilter(request,response);
            return;
        }

        if(!atribute.startsWith(ATRIBUTE_PREFIX)){
            chain.doFilter(request,response);
            return;
        }

        String token = atribute.replace(ATRIBUTE_PREFIX,"");

        UsernamePasswordAuthenticationToken authToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authToken);
        chain.doFilter(request,response);

    }

    //Tradução do token para verificar o usuario e gerar um token
    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
        String user = JWT.require(Algorithm.HMAC512(JWTAuthenticationFilter.TOKEN_SECRET))
                .build()
                .verify(token)
                .getSubject();

        if(user == null){
            return null;
        }

        return new UsernamePasswordAuthenticationToken(user,null, new ArrayList<>());
    }

}
