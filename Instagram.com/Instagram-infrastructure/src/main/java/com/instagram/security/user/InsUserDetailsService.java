package com.instagram.security.user;

import com.instagram.persistence.model.entity.UserInfrastructureEntity;
import com.instagram.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsUserDetailsService implements UserDetailsService {
    private final JpaUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfrastructureEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by email: " + email);
        }
        return InsUserDetails.buildUserDetail(user);
    }
}
