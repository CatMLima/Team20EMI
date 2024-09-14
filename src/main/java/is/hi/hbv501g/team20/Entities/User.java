package is.hi.hbv501g.team20.Entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class User {

    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String email;
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    //onetomany enables a user to have many study activities
    private List<StudyActivity> activities;

    //Constuctors
    public User() {
    }

    public User(UUID id, String username, String email, String name, String password, list<StudyActivity> activities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.password = password;
        this.activities = activities;
    }
    //getters and setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<StudyActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<StudyActivity> activities) {
        this.activities = activities;
    }
}
