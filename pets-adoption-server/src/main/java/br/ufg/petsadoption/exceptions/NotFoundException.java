package br.ufg.petsadoption.exceptions;

import java.io.Serial;

public class NotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3043931591455360560L;

    public NotFoundException(String message) {
        super(message);
    }
}
