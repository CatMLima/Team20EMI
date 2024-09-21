package is.hi.hbv501g.team20.Entities;

import jakarta.persistence.*;

import java.awt.*;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
public class StudyActivity {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Time start;

    @Temporal(TemporalType.TIME)
    private Time end;

    @ManyToOne //Here the study activity is the Many and the subject is the One, one subject to many study activities
    @JoinColumn(name = "subject_id")
    private Subject subject;

    //Here the study activity is the One and the Many is coffees, one study activity has many coffees
    @OneToMany(mappedBy = "studyActivity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coffee> coffees;

    //One study activity has one image
    @OneToOne(cascade = CascadeType.ALL)
    //Cascade means that if you delete the study activity then the image will also be deleted
    @JoinColumn(name = "user_id")
    private Image picture;

    @ManyToOne //one user can have many study activities.
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    // Constructors
    public StudyActivity() {
    }

    public StudyActivity(UUID id, Date date, Time start, Time end, Subject subject, List<Coffee> coffees, Image picture, String description, User user, Location location) {
        this.id = id;
        this.date = date;
        this.start = start;
        this.end = end;
        this.subject = subject;
        this.coffees = coffees;
        this.picture = picture;
        this.description = description;
        this.user = user;
        this.location = location;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(List<Coffee> coffees) {
        this.coffees = coffees;
    }

    public Image getImage() {
        return picture;
    }

    public void setImage(Image image) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

