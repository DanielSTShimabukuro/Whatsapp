package whatsapp.whatsapp.application.exceptions;

public class UserTagConflictException extends RuntimeException {

    public UserTagConflictException(String userTag) {
        super(String.format("A tag '%s' já está em uso", userTag));
    }
}
