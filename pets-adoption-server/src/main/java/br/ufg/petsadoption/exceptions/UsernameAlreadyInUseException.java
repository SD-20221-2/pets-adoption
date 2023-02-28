package br.ufg.petsadoption.exceptions;

import java.io.Serial;

public class UsernameAlreadyInUseException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3901542724599997853L;

    public UsernameAlreadyInUseException(String message) {
        super(message);
    }
}
