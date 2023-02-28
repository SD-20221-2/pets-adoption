package br.ufg.petsadoption.services;

import br.ufg.petsadoption.dtos.UserDto;
import br.ufg.petsadoption.exceptions.UsernameAlreadyInUseException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void throwExceptionIfExists(String username) throws UsernameAlreadyInUseException;

    void create(UserDto dto);
}
