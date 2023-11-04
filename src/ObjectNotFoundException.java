public class ObjectNotFoundException extends RuntimeException{

    String message;
    String objectNumber;
    public ObjectNotFoundException(String objectNumber){
        super();
        this.objectNumber = objectNumber;
    }


    public  ObjectNotFoundException(String objectNumber, String message){
        this.objectNumber = objectNumber;
        this.message = message;
    }

    @Override
    public String toString() {
        if(this.message == null) {
            return objectNumber + " not found";
        }
        else {
            return objectNumber + " not found: " + message;
        }
    }
}
