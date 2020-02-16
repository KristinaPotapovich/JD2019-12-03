package by.it.samuseva.calc;

public class CalcException extends Exception{
    public CalcException() {
    }

    public CalcException(String message) {
        super("Error " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("Error " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }

    public CalcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("Error " + message, cause, enableSuppression, writableStackTrace);
    }
}
