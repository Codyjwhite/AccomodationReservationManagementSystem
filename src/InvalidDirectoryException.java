import java.io.FileNotFoundException;

public class InvalidDirectoryException extends FileNotFoundException {
    String directoryPath;
    String message = null;

    InvalidDirectoryException(String directoryPath) {
        super();
        this.directoryPath = directoryPath;
    }
    InvalidDirectoryException(String directoryPath, String message){
        this.directoryPath = directoryPath;
        this.message = message;
    }

    @Override
    public String toString() {
        if(message == null) {
            return directoryPath + " not found";
        }
        else {
            return directoryPath + " not found: " + message;
        }
    }
}
