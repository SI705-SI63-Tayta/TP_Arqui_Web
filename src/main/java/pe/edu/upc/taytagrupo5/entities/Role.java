package pe.edu.upc.taytagrupo5.entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Role", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","rol"})})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @Column(name = "descriptionRole", nullable = false, length = 50)
    private String descriptionRole;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    public Role (){

    }

    public Role(Long idRole, String descriptionRole, User user) {
        this.idRole = idRole;
        this.descriptionRole = descriptionRole;
        this.user = user;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        this.descriptionRole = descriptionRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
