package whatsapp.whatsapp.application.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() { super("Usuário não pôde ser encontrado"); }

    public UserNotFoundException(String message) { super(message); }
}