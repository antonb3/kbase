package com.antonb.kbase;

import com.antonb.kbase.entity.User;
import com.antonb.kbase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUsername(username);
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUsername(user.getUsername());
        customUserDetails.setPassword(user.getPassword());
        return customUserDetails;
    }
}
