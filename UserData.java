import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Objects;

public class UserData {
    public UserData(){
        initializeComponent();
    }
    public void initializeComponent(){
        String input = scanner();
        if (checkInputLength(input)) {
            String[] data = checkInput(input);
            String formatData = formatData(data);
            if (readCheckData(data[0],formatData)) {
                writeData(formatData, data[0]);
                
            }
            
        }
    }
    public String formatData(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (String s : array){
            sb.append("<").append(s).append(">");
        }
        return sb.toString();
    }
    public String scanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел: строка должна содержать Ф.И.О, дату рождения, номер телефона, пол ");
        return scanner.nextLine();
    }   
    public boolean checkInputLength(String data) {
        String[] array = data.split(" ");
        try {
            if (array.length !=6) {
                throw new ExceptionData(array.length);
                
            }
            
        } catch (ExceptionData e) {
            System.err.println(e.getMessage());
            return false;   
        }
        return true;
    }
    public String[] checkInput(String data){
        String[] array = data.split(" ");
        try {for (int index = 0; index < 2; index++) {
            validateLetterOnly(array[index]);
        }
            
        } catch (ExceptionType e) {
            System.err.println(e.getMessage()); 
        }
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            dateFormat.setLenient(false);
            Date parsedDate = dateFormat.parse(array[3]);
        } catch (ParseException e) {
            try{
                throw new WpParseException("Дата роЖдения долЖна быть в формате dd.MM.yyyy: " +array[3]);

            } catch(WpParseExaption ex){
                System.err.println(ex.getMessage());
            }

        }
        try{
            Long.parseLong(array[4]);
        } catch (Exception e){
            try{
                throw new WpParseExaption("Неверный тип данных номера телефона: " +array[4]);
            }catch (WpParseExaption ex) {
                System.err.println(ex.getMessage());
            }
        }
        try {
            if (!Object.equals(array[5], "f") && !Object.equals(array[5],"m")) {
                throw new ExceptionGender(array[5]);
            }
        } catch (ExceptionGender ex){
        System.err.println(ex.getMessage());
        }
        return array;
    }
    public void validateLetterOnly(String data){
        char[] charArray = data.toCharArray();
        for (char c: charArray){
            if (!Character.isLetter(c)) {
                throw new ExceptionType(data);
                
            }
        }
    }
}
