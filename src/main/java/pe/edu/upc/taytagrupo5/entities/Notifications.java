package pe.edu.upc.taytagrupo5.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notificaciones")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotification;
    @Column(name = "message", nullable = false,length = 30)
    private String message;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idRecipes")
    private Recipes recipes;

    public Notifications() {
    }

    public Notifications(int idNotification, String message, User user, Recipes recipes) {
        this.idNotification = idNotification;
        this.message = message;
        this.user = user;
        this.recipes = recipes;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }
}
