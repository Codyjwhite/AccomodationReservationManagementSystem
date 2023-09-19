public class ObjectAlreadyExistsException extends Exception{
    String message;
    String objectNumber;

    public ObjectAlreadyExistsException(String objectNumber) {
        super();
        this.objectNumber = objectNumber;
    }

    public ObjectAlreadyExistsException(String objectNumber, String message) {
        super();
        this.objectNumber = objectNumber;
        this.message = message;
    }

    @Override
    public String toString() {
        if(message == null) {
            return objectNumber + " already exists.";
        }
        else{
            return objectNumber + " already exists: + " + message;
        }

    }
}
