package es.upm.miw.apiArchitectureUser.entities;

import java.util.Calendar;

public class User {

    private int id;

    private String name;
    
    private Calendar date;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.date = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

	public Calendar getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
