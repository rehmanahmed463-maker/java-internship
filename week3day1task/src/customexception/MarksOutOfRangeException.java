package customexception;

public class MarksOutOfRangeException extends Exception {
    public MarksOutOfRangeException(String message){
        super(message);
    }
}
