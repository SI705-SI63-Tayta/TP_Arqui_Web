package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dailyActivities")
public class DailyActivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActivity;

    @Column(name = "habits", nullable = false,length = 100)
    private String habits;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public DailyActivities() {
    }

    public DailyActivities(int idActivity, String habits, User user) {
        this.idActivity = idActivity;
        this.habits = habits;
        this.user = user;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
