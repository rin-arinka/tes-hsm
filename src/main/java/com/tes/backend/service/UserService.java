package com.tes.backend.service;

import com.tes.backend.entity.User;
import com.tes.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {

        String hashedPassword =
                passwordEncoder.encode(user.getPassword());

        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public boolean login(String email, String password) {

        User user = userRepository.findByEmail(email)
                orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        return passwordEncoder.matches(
                password,
                user.getPassword()
        );
    }
}
