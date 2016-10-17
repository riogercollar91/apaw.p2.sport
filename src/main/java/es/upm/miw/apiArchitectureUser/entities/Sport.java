package es.upm.miw.apiArchitectureUser.entities;

public class Sport {

    private int id;

    private String sport;

    private User user;

    public Sport(String sport) {
        this.sport = sport;
    }

    public Sport(String sport, User user) {
        this.sport = sport;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Sport [id=" + id + ", value=" + sport + ", user=" + user + "]";
    }

}
