public class ObjectAlreadyExistsException extends Exception{
    String message;

    public ObjectAlreadyExistsException(){}

    public ObjectAlreadyExistsException(String objectNumber, String message) {
        super(objectNumber + " already exists: + " + message);
    }
}
