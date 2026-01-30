package customexception;

public class InvalidLoginException extends Exception {
    public InvalidLoginException(String message){
        super(message);
    }
}
