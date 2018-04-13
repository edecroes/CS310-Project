package cs310.team.project;
import java.sql.*;
import java.util.*;

public class TASDatabase {
    Connection conn;
    
    public TASDatabase() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            String url = "jdbc:mysql://localhost/tas";
            
            conn = DriverManager.getConnection(url,"cs310","spring2018");
            
        } 
        
        catch (Exception ex) {
            System.out.println(ex.toString()+" CONNECTION FAILED");
        }
    }
    public Badge getBadge(String badgeid){
        try {
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM badge WHERE id ='"+badgeid+"'");
        r.next();
        
        String id = r.getString("id");
        String desc = r.getString("description");
        return new Badge(id,desc);
        
        }
        catch(SQLException e) {System.out.println(e.toString()+" BADGE GET FAIL");}
        return null;
    }
    /**
     * copy above
     * @param punchid
     * @return
     * @throws SQLException 
     */
    public Punch getPunch(int punchid) {
        try {
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT *,UNIX_TIMESTAMP(originaltimestamp)*1000 AS ts FROM event WHERE id ='"+punchid+"'");
            r.beforeFirst();
            r.next();
            int id = r.getInt("id");
            int terminalid = r.getInt("terminalid");
            String badgeid = r.getString("badgeid");
            long ts = r.getLong("ts");
            GregorianCalendar originaltimestamp = new GregorianCalendar();
            originaltimestamp.setTimeInMillis(ts);
            int eventtypeid = r.getInt("eventtypeid");
            r.close();
            s.close();
            return new Punch(id,terminalid,badgeid,originaltimestamp,eventtypeid,null); //always null for some reason
            //RETURN new punch(POW*)
            
            //return new Punch()
        }
        catch(Exception e ){ System.out.println(e.toString()+": NOT A PUNCH");}
        return null;
    
    }
    
    public Shift getShift(int shiftid){
        //NOT MODIFIED YET
       
        String desc;
        int id,interval,graceperiod,dock,lunchdeduct;
        Time start,stop,lunchstart,lunchstop;
        try{
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM shift WHERE id ='"+shiftid+"'");
            r.next();
            id = r.getInt("id");
            desc = r.getString("description");
            start = Time.valueOf(r.getString("start"));
            stop = Time.valueOf(r.getString("stop"));
            interval = r.getInt("interval");
            graceperiod = r.getInt("graceperiod");
            dock = r.getInt("dock");
            lunchstart = Time.valueOf(r.getString("lunchstart"));
            lunchstop = Time.valueOf(r.getString("lunchstop"));
            lunchdeduct = r.getInt("lunchdeduct");
            return new Shift(id,desc,start,stop,interval,graceperiod,dock,lunchstart,lunchstop,lunchdeduct);
            
        }
        catch(Exception e ) {System.out.println(e.toString()+": GET SHIFT ON ID FAIL");}
        return null;
        
    }
    
    public Shift getShift(Badge b){
       
       try{
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM employee WHERE badgeid ='"+b.getid()+"'");
            r.next();
            return getShift(r.getInt("shiftid"));
            
        }
        catch(Exception e) {System.out.println(e.toString()+": GET SHIFT ON BADGE FAIL");}
        return null;
        
    }
    
    
    /**
    public static GregorianCalendar getCalendar(String cid){
        //2017-08-01 05:54:04
        
        int year = Integer.getInteger(cid.substring(0,4));
        int month = Integer.getInteger(cid.substring(5,7));
        int dayOfMonth = Integer.getInteger(cid.substring(8,10));
        int hourOfDay = Integer.getInteger(cid.substring(11,13));
        int minute = Integer.getInteger(cid.substring(14,16));
        int second = Integer.getInteger(cid.substring(17,19));
        
        System.out.println(cid);
        System.out.println(year + " " + month + " " + dayOfMonth+ " " + hourOfDay+ " "+ minute + " " + second);
        
        return new GregorianCalendar(year,month,dayOfMonth, hourOfDay, minute, second);
        
        
    }
    */
    
    
    public int insertPunch(Punch p) throws SQLException{
        //Gusztav, Kuvvat
        return 0;
    }

    public ArrayList getDailyPunchList(Badge b, GregorianCalendar ts){
        //Who?
        
        return null;
    }
}