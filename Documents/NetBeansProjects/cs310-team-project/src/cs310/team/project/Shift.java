package cs310.team.project;
import java.util.*;
import java.sql.*;

public class Shift {

private int id;
private String description;
private Time start; //these GregorianCalendar objects should only contain time values and only compared against their time instance variables!
private Time stop;
private int interval;
private int graceperiod;
private int dock;
private Time lunchstart;
private Time lunchstop;
private int lunchdeduct;

public Shift(int id, String description, Time start, Time stop, int interval, int graceperiod, int dock, Time lunchstart, Time lunchstop, int lunchdeduct) {
	this.id = id;
	this.description = description;
	this.start = start;
	this.stop = stop;
	this.interval = interval;
	this.graceperiod = graceperiod;
	this.dock = dock;
	this.lunchstart = lunchstart;
	this.lunchstop = lunchstop;
	this.lunchdeduct = lunchdeduct;
}

public int getid() {
	return this.id;
}

public void setid(int id) {
	this.id = id;
}

public String getdescription() {
	return this.description;
}

public void setdescription(String description) {
	this.description = description;
}

public Time getstart() {
	return this.start;
}

public void setstart(Time start) {
	this.start = start;
}

public Time getstop() {
	return this.stop;
}

public void setstop(Time stop) {
	this.stop = stop;
}

public int getgraceperiod() {
	return this.graceperiod;
}

public void setgraceperiod(int graceperiod) {
	this.graceperiod = graceperiod;
}

public int getinterval() {
	return this.interval;
}

public void setinterval(int interval) {
	this.interval = interval;
}

public int getdock() {
	return this.dock;
}

public void setdock(int dock) {
	this.dock = dock;
}

public Time getlunchstart() {
	return this.lunchstart;
}

public void setlunchstart(Time lunchstart) {
	this.lunchstart = lunchstart;
}

public Time getlunchstop() {
	return this.lunchstop;
}

public void setlunchstop(Time lunchstop) {
	this.lunchstop = lunchstop;
}

public int getlunchdeduct() {
	return this.lunchdeduct;
}

public void setlunchdeduct(int lunchdeduct) {
	this.lunchdeduct = lunchdeduct;
}



}