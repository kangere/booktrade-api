package booktrade.api.exception;

public class WrongPasswordException extends RuntimeException {

    public WrongPasswordException(){
        super("Invalid password");
    }
}
