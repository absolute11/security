package org.example.securityproject.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("Denis".equals(username)) {
            return User.withUsername("Denis").password("password").roles("READ").build();
        } else if ("admin".equals(username)) {
            return User.withUsername("admin").password("password").roles("WRITE").build();
        } else if ("admin2".equals(username)) {
            return User.withUsername("admin2").password("password").roles("DELETE").build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
