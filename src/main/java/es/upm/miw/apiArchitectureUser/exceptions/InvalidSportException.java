package es.upm.miw.apiArchitectureUser.exceptions;

public class InvalidSportException extends Exception {
    private static final long serialVersionUID = -5173361541880534566L;

    public static final String DESCRIPTION = "El valor del deporte debe estar entre 0 y 10";

    public InvalidSportException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public InvalidSportException() {
        this("El deporte ya existe");
    }

}
