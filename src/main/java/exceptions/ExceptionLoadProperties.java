package exceptions;

public class ExceptionLoadProperties extends Throwable {
    public ExceptionLoadProperties(String message, Throwable causa) {
        super(message, causa);
    }
}
