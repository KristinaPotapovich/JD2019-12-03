package by.it.lozouski.calc;

class CalcException extends Exception {
    public CalcException() {
    }

    public CalcException(String message) {
        super("Message error: " + message);
    }

    public CalcException(String message, Throwable cause) {
        super("Message error: " + message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
