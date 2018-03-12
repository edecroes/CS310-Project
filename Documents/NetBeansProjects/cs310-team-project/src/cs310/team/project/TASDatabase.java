package cs310.team.project;
import java.sql.*;
import java.util.*;

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
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM punch WHERE id =\'"+punchid+"\'");
        if(r != null){
            int id = r.getInt("id");
            int terminalid = r.getInt("terminalid");
            String badgeid = r.getString("badgeid");
            GregorianCalendar originaltimestamp = getCalendar(r.getString("originaltimestamp"));
            boolean eventtypeid = r.getBoolean("eventtypeid");
            
            
            return new Punch(id,terminalid,badgeid,originaltimestamp,eventtypeid,null); //always null for some reason
            //RETURN new punch(POW*)
            
            //return new Punch()
        }
        throw new SQLException("Bad PunchID");
    }
    
    public Shift getShift(int shiftid) throws SQLException{
        //NOT MODIFIED YET
        Statement s = conn.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM shift WHERE id =\'"+shiftid+"\'");
        String desc;
        int id,interval,graceperiod,dock,lunchdeduct;
        GregorianCalendar start,stop,lunchstart,lunchstop;
        if(r != null){
            id = r.getInt("id");
            desc = r.getString("description");
            start = (GregorianCalendar) (getCalendar(r.getString("start")));
            stop = (GregorianCalendar) (getCalendar(r.getString("stop")));
            interval = r.getInt("interval");
            graceperiod = r.getInt("graceperiod");
            dock = r.getInt("dock");
            lunchstart = (GregorianCalendar) (getCalendar(r.getString("lunchstart")));
            lunchstop = (GregorianCalendar) (getCalendar(r.getString("lunchstop")));
            lunchdeduct = r.getInt("lunchdeduct");
            
        }
        else
            throw new SQLException("Bad ShiftID");
        
        return new Shift(id,desc,start,stop,interval,graceperiod,dock,lunchstart,lunchstop,lunchdeduct);
    }
    
    public Shift getShift(Badge b) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet r2 = s.executeQuery("SELECT * FROM employee WHERE id =\'"+b.getid()+"\'");
        ResultSet r = s.executeQuery("SELECT * FROM shift WHERE id =\'"+r2.getString("shiftid")+"\'");
        String desc;
        int id,interval,graceperiod,dock,lunchdeduct;
        GregorianCalendar start,stop,lunchstart,lunchstop;
       if(r != null){
            id = r.getInt("id");
            desc = r.getString("description");
            start = (GregorianCalendar) (getCalendar(r.getString("start")));
            stop = (GregorianCalendar) (getCalendar(r.getString("stop")));
            interval = r.getInt("interval");
            graceperiod = r.getInt("graceperiod");
            dock = r.getInt("dock");
            lunchstart = (GregorianCalendar) (getCalendar(r.getString("lunchstart")));
            lunchstop = (GregorianCalendar) (getCalendar(r.getString("lunchstop")));
            lunchdeduct = r.getInt("lunchdeduct");
            
        }
        else
            throw new SQLException("Bad ShiftID");
        
        return new Shift(id,desc,start,stop,interval,graceperiod,dock,lunchstart,lunchstop,lunchdeduct);
    }
    
    
    
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
}