package Errors;

public class CustomError extends Error{
    public CustomError(String message) {
        super(message);
    }

    public CustomError(String message, Throwable cause) {
        super(message, cause);
    }


}
