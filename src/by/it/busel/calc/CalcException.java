package by.it.busel.calc;

@SuppressWarnings("all")
class CalcException extends Exception {
    CalcException() {
    }

    CalcException(String message) {
        super("ERROR: " + message);
    }

    CalcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    CalcException(Throwable cause) {
        super(cause);
    }
}
