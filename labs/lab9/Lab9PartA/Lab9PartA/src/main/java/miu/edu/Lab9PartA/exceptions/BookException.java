package miu.edu.Lab9PartA.exceptions;
//cusotom exception

public class BookException extends RuntimeException{
    //exception methods
    public BookException(String message) {
        super(message);
    }
    public BookException(String message, Throwable cause) {
        super(message, cause);
    }
    public BookException(Throwable cause) {
        super(cause);
    }

}
