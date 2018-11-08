package view;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Mail;

public class MailListReader {
    private  ArrayList<Mail> list = new ArrayList();
    
    public ArrayList read(String fileName) throws FileNotFoundException, IOException{
        String string;
        FileReader f = new FileReader(fileName);
        BufferedReader b = new BufferedReader(f);
        while((string = b.readLine())!=null) {
            if(string.contains("@")){
                list.add(new Mail(string));
            }
        }
        b.close();
        return list;
    }
}
