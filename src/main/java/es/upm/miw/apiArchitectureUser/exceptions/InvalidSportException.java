package es.upm.miw.apiArchitectureUser.exceptions;

public class InvalidSportException extends Exception {
    private static final long serialVersionUID = -5173361541880534566L;

    public static final String DESCRIPTION = "El deporte no existe";

    public InvalidSportException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidSportException() {
        this("El deporte ya existe");
    }

}
