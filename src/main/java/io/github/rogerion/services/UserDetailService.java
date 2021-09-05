package io.github.rogerion.services;

import io.github.rogerion.data.userDataDetail;
import io.github.rogerion.entities.User;
import io.github.rogerion.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailService implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByEmail(username));
        if (!user.isPresent()){
            throw new UsernameNotFoundException("Usuario "+username+" nao encontrado");
        }
        return new userDataDetail(user);
    }
}
