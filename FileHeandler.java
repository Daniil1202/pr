import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHeandler {
    public void writeData(String data, String path) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            if (file.length() > 0)
                bw.newLine();
            
            bw.write(data);
            bw.close();
            System.out.println("Данные успешно добавлены в файл.");
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
    public static boolean readData(String data, String path){
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) !=null){
                if(line.equals(data)) {
                    System.out.println("Пользователь уже есть в списке");
                    return false;
                }
            }
            bufferedReader.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }
    
}
