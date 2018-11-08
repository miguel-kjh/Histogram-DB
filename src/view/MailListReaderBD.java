package view;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import model.Mail;

public class MailListReaderBD {
    private  ArrayList<Mail> list = new ArrayList();
    
    private Connection connect() {
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public ArrayList read() throws FileNotFoundException, IOException{
        String sql = "SELECT * FROM email";
        try (Connection conn = this.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                if(rs.getString("direccion").contains("@")){
                    list.add(new Mail(rs.getString("direccion")));
                }
            }   
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
