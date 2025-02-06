package peaksoft.springbootanddatajpa.entities;

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

    public User() {
    }

    public User(Long id, String username, String email, int age, List<Car> cars) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
