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
    public Badge getBadge(String badgeid) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM badge WHERE id =\'"+badgeid+"\'");
        if(r != null){
            String id = r.getString("id");
            String desc = r.getString("description");
            return new Badge(id,desc);
        }
        throw new SQLException("Bad BadgeID");
    }
    /**
     * copy above
     * @param punchid
     * @return
     * @throws SQLException 
     */
    public Punch getPunch(String punchid) throws SQLException{
        return null;
    }
    
    public Shift getShift(String shiftid) throws SQLException{
        return null;
    }
    
    public Shift getShift(Badge b) throws SQLException{
        return null;
    }
}