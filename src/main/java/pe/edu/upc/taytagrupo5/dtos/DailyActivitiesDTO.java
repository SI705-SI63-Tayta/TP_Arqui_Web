package pe.edu.upc.taytagrupo5.dtos;

import pe.edu.upc.taytagrupo5.entities.User;

public class DailyActivitiesDTO {
    private int idDailyActivities;
    private String habits;
    private User user;

    public int getIdDailyActivities() {
        return idDailyActivities;
    }

    public void setIdDailyActivities(int idDailyActivities) {
        this.idDailyActivities = idDailyActivities;
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
