package peaksoft.springbootanddatajpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_gen")
    private Long id;
    private String username;
    private String email;
    private int age;
    @OneToMany(mappedBy = "user")
    private List<Car> cars;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = {
            CascadeType.REMOVE,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<Post> posts;

    public User() {
    }

    public User(Long id, String username, String email, int age, List<Car> cars, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.cars = cars;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
