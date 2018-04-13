package cs310.team.project;
import java.util.*;
import java.text.*;

public class Punch {
private int id;
private int terminalid;
private String badgeid;
private GregorianCalendar originaltimestamp;
private int eventtypeid;
private Object eventdata;

public Punch(int id, int terminalid, String badgeid, GregorianCalendar originaltimestamp, int eventtypeid, Object eventdata) {
	this.id = id;
	this.terminalid = terminalid;
	this.badgeid = badgeid;
	this.originaltimestamp = originaltimestamp;
	this.eventtypeid = eventtypeid;
	this.eventdata = eventdata;
}

public int getid() {
	return this.id;
}

public void setid(int id) {
	this.id = id;
}

public int getterminalid() {
	return this.terminalid;
}

public void setterminalid(int terminalid) {
	this.terminalid = terminalid;
}

public String getbadgeid() {
	return this.badgeid;
}

public void setbadgeid(String badgeid) {
	this.badgeid = badgeid;
}

public GregorianCalendar getoriginaltimestamp() {
	return this.originaltimestamp;
}

public void setoriginaltimestamp(GregorianCalendar originaltimestamp) {
	this.originaltimestamp = originaltimestamp;
}

public int geteventtypeid() {
	return this.eventtypeid;
}

public void seteventtypeid(int eventtypeid) {
	this.eventtypeid = eventtypeid;
}

public Object geteventdata() {
	return this.eventdata;
}

public void seteventdata(Object eventdata) {
	this.eventdata = eventdata;
}

public String printOriginalTimestamp() {
    //"#D2C39273 CLOCKED IN: WED 09/06/2017 07:00:07"

    //format string: "EEE "
    SimpleDateFormat s = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");      
    
    String ots = s.format(this.originaltimestamp.getTime()).toUpperCase(); 
    
    return "#"+this.badgeid+" CLOCKED IN: "+ ots;


}

}