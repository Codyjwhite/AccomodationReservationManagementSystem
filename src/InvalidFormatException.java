public class InvalidFormatException extends Exception {
    String message;

    public InvalidFormatException() {

        super("Invalid format: Data does not meet expected format");
    }

    public InvalidFormatException(String message) {

        super("Invalid format: " + message);
    }
}

