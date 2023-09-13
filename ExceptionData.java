public class ExceptionData extends RuntimeException {
    public ExceptionData(int length) {

        super("Количество данных должно быть 6, введено " + length);

    }
}