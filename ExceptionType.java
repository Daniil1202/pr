public class ExceptionType extends RuntimeException {
    public ExceptionType(String data) {
        super("Неверный тип данный в ФИО: "+ data);
    }

    
}