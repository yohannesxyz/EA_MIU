package bank.exceptions;

public class InsufficientBalanceException extends RuntimeException{
    //exception methods
    public InsufficientBalanceException(String message) {
        super(message);
    }
    public InsufficientBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
    public InsufficientBalanceException(Throwable cause) {
        super(cause);
    }
}
