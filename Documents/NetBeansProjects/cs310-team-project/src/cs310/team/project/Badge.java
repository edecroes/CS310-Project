package cs310.team.project;
public class Badge {

private String id;
private String description;

public Badge(String id, String description) {
	this.id = id;
	this.description = description;
}

public String getid() {
	return this.id;
}

public void setid(String id) {
	this.id = id;
}

public String getdescription() {
	return this.description;
}

public void setdescription(String description) {
	this.description = description;
}

}