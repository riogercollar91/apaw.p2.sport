package es.upm.miw.apiArchitectureUser.exceptions;

public class InvalidUserFieldException extends Exception {
    private static final long serialVersionUID = -642045799876625537L;

    public static final String DESCRIPTION = "Nombre del usuario no encontrado";

    public InvalidUserFieldException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidUserFieldException() {
        this("");
    }

}
