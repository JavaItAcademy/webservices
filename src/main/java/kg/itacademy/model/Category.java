package kg.itacademy.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;

@XmlRootElement(name="category")
@XmlAccessorType(XmlAccessType.FIELD)
public class Category {
    private int id;
    private String name;
    private User user;
    private boolean isActive;

    public Category() {}

    public Category(int id, String name, User user, boolean isActive) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
