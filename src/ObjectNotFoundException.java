public class ObjectNotFoundException extends Exception {

    String message;

    public ObjectNotFoundException(){
        super("Object not found");
    }

    //TODO either add message or remove message parameter
    public  ObjectNotFoundException(String objectNumber, String message){

        super(objectNumber + " not found");
    }
}
