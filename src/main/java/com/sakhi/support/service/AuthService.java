package com.sakhi.support.service;

import com.sakhi.support.dto.AuthResponseDto;
import com.sakhi.support.dto.LoginRequestDto;
import com.sakhi.support.dto.RegisterRequestDto;
import com.sakhi.support.model.Role;
import com.sakhi.support.model.User;
import com.sakhi.support.repository.RoleRepository;
import com.sakhi.support.repository.UserRepository;
import com.sakhi.support.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponseDto register(RegisterRequestDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Default role not found. Did you seed the roles table?"));

        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPhone(dto.getPhone());
        user.setRole(userRole);

        User saved = userRepository.save(user);

        String token = jwtUtil.generateToken(saved.getEmail(), saved.getRole().getName());

        return new AuthResponseDto(
                "Registration successful",
                saved.getId(),
                saved.getFullName(),
                saved.getEmail(),
                token
        );
    }

    public AuthResponseDto login(LoginRequestDto dto) {

        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        if (!user.getIsActive()) {
            throw new RuntimeException("This account has been disabled");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().getName());

        return new AuthResponseDto(
                "Login successful",
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                token
        );
    }
}