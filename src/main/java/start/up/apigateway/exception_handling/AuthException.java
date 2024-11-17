package start.up.apigateway.exception_handling;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
