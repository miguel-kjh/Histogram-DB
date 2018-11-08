package view;

import java.util.ArrayList;
import model.Histogram;
import model.Mail;

public class MailHistogreamBuilder {
    public Histogram<String> build(ArrayList<Mail> list){
        Histogram<String> hist = new Histogram();
        for(Mail element:list){
            hist.increment(element.getDomain());
        }
        return hist;
    }
}
