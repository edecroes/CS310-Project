package cs310.team.project;
import java.util.*;

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

public String getid() {
	return this.id;
}

public void setid(String id) {
	this.id = id;
}

public String getterminalid() {
	return this.terminalid;
}

public void setterminalid(String terminalid) {
	this.terminalid = terminalid;
}

public String getbadgeid() {
	return this.badgeid;
}

public void setbadgeid(String badgeid) {
	this.badgeid = badgeid;
}

public String getoriginaltimestamp() {
	return this.originaltimestamp;
}

public void setoriginaltimestamp(String originaltimestamp) {
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





}