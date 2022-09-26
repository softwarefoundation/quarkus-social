package com.softwarefoundation.exception;

public class RegistroNaoLocalizadoException extends RuntimeException{

    public RegistroNaoLocalizadoException(String message) {
        super(message);
    }

    public RegistroNaoLocalizadoException() {
        super("Registro não localizado");
    }
}
