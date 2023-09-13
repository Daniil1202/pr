public class ExceptionGender extends RuntimeException {
    public ExceptionGender(String data) {
        super("Неверный пол, допустимо 'm' или'f': " + data);

    }
    
    
    
}
