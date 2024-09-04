package pe.edu.upc.taytagrupo5.dtos;


import pe.edu.upc.taytagrupo5.entities.Recipes;
import pe.edu.upc.taytagrupo5.entities.User;

public class NotificationsDTO {
    private int idNotification;
    private String message;
    private User user;
    private Recipes recipes;

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
