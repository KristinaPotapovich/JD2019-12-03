package by.it.ban.calc;

public class CalcException extends Exception{
    static ResManager lang = ResManager.INSTANCE;
    public CalcException() {
        super();
    }

    public CalcException(String message) {
        super(lang.get(ErrorMessages.ERR)+" "+message);
    }

    public CalcException(String message, Throwable cause) {
        super(lang.get(ErrorMessages.ERR)+" "+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
