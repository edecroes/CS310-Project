package cs310.team.project;
import java.util.*;
import java.text.*;

public class Punch {
private int id;
private int terminalid;
private String badgeid;
private GregorianCalendar originaltimestamp;
private boolean eventtypeid;
private Object eventdata;

public Punch(int id, int terminalid, String badgeid, GregorianCalendar originaltimestamp, boolean eventtypeid, Object eventdata) {
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

public boolean geteventtypeid() {
	return this.eventtypeid;
}

public void seteventtypeid(boolean eventtypeid) {
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
    SimpleDateFormat s = new SimpleDateFormat("EEE ");      
    return "#"+this.id+" CLOCKED IN "+s.format()+ 
    
}




}