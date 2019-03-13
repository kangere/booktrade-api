package booktrade.api.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email){
        super("Could not Find User " + email);
    }
}
