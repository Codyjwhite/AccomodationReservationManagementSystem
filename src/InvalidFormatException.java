public class InvalidFormatException extends IllegalArgumentException {
    String message;

    public InvalidFormatException() {
    }

    public InvalidFormatException(String message) {

        super();
        this.message = "Expected format:" + message;
    }

    @Override
    public String toString() {
        return "Invalid format: Data does not meet expected format " + message;
    }
}
