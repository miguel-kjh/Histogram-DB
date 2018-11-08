import java.io.IOException;
import java.util.ArrayList;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogreamBuilder;
import view.MailListReaderBD;

public class Kata5P2 {
    private MailListReaderBD m;
    private ArrayList<Mail> list;
    private MailHistogreamBuilder hist;
    private HistogramDisplay histo;
    public static void main(String[] args) throws IOException {
        Kata5P2 Kata5P2 = new Kata5P2();
        Kata5P2.execute();

        
    }

    private void execute() throws IOException {
        input();
        process();
        output();
        
    }

    private void input() {
        m = new MailListReaderBD();
        hist = new MailHistogreamBuilder();
    }

    private void process() throws IOException {
        list = m.read();
        histo = new HistogramDisplay("HISTOGRAMA DE EMAILS", hist.build(list));
    }

    private void output() {
        histo.execute();
    }
    
}

