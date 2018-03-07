package cs310.team.project;
import java.sql.*;

public class TASDatabase {
    Connection conn;
    
    public TASDatabase() throws SQLException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String url = "jdbc:mysql://localhost/tas";
            
            conn = DriverManager.getConnection(url,"cs310","spring2018");
            
        } 
        
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}