package lk.ijse.pharmacy.service.exception;

public class InUseException extends RuntimeException{
    public InUseException() {
        super();
    }

    public InUseException(String message) {
        super(message);
    }

    public InUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InUseException(Throwable cause) {
        super(cause);
    }

    protected InUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
