package com.amazinbookstore.amazin.authentication;


import com.amazinbookstore.amazin.entities.User;
import com.amazinbookstore.amazin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private org.springframework.security.core.userdetails.User User;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        UserDetails user = User.builder()
                .username(optionalUser.get().getEmail())
                .password(optionalUser.get().getPassword())
                .roles("ADMIN")
                .build();

        if (user.getUsername().equals(username)) {
            return user;
        }

        throw new UsernameNotFoundException("user not found");
    }
}
