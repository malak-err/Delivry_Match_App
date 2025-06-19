package com.deliverymatch.deliverymatch.service;


import com.deliverymatch.deliverymatch.Dto.AuthRequest;
import com.deliverymatch.deliverymatch.Dto.AuthResponse;
import com.deliverymatch.deliverymatch.Dto.ConducteurRegisterDto;
import com.deliverymatch.deliverymatch.Dto.ExpediteurRegisterDto;
import com.deliverymatch.deliverymatch.Model.Conducteur;
import com.deliverymatch.deliverymatch.Model.Expediteur;
import com.deliverymatch.deliverymatch.Model.Role;
import com.deliverymatch.deliverymatch.Model.User;
import com.deliverymatch.deliverymatch.Repository.UserRepository;
import com.deliverymatch.deliverymatch.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse registerConducteur(ConducteurRegisterDto request) {
        Conducteur user = new Conducteur();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.CONDUCTEUR);

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();
    }

    public AuthResponse registerExpediteur(ExpediteurRegisterDto request) {
        Expediteur user = new Expediteur();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.EXPEDITEUR);

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .role(user.getRole().name())
                .build();
    }
}