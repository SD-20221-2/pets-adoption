package br.ufg.petsadoption.services.impl;

import br.ufg.petsadoption.dtos.UserDto;
import br.ufg.petsadoption.entities.User;
import br.ufg.petsadoption.exceptions.UsernameAlreadyInUseException;
import br.ufg.petsadoption.repositories.UserRepository;
import br.ufg.petsadoption.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return Optional
                .ofNullable(user)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
    }

    @Override
    public void throwExceptionIfExists(String username) throws UsernameAlreadyInUseException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            throw new UsernameAlreadyInUseException("Username já em uso: " + username);
        }
    }

    @Override
    public void create(UserDto dto) {
        var user = new User();
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        userRepository.save(user);
    }
}
