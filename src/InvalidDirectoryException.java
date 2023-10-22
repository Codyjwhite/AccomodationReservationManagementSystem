import java.io.FileNotFoundException;
import java.io.IOException;

public class InvalidDirectoryException extends IOException {
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
    public String getMessage() {
        if(message == null) {
            return directoryPath + " not found";
        }
        else {
            return directoryPath + " not found: " + message;
        }
    }
}
