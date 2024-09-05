package pe.edu.upc.taytagrupo5.dtos;


import pe.edu.upc.taytagrupo5.entities.Recipe;
import pe.edu.upc.taytagrupo5.entities.User;

public class NotificationDTO {
    private int idNotification;
    private String message;
    private User user;
    private Recipe recipe;

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

    public Recipe getRecipes() {
        return recipe;
    }

    public void setRecipes(Recipe recipe) {
        this.recipe = recipe;
    }
}
