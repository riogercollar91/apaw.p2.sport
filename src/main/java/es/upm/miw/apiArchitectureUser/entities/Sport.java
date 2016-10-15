package es.upm.miw.apiArchitectureUser.entities;

public class Sport {

    private int id;

    private int value;

    private User user;

    public Sport() {
    }

    public Sport(int value, User user) {
        this.value = value;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
        return value;
    }

    public User getUser() {
        return user;
    }

	@Override
	public String toString() {
		return "Sport [id=" + id + ", value=" + value + ", user=" + user + "]";
	}

}
