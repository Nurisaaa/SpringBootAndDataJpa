package peaksoft.springbootanddatajpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.processing.Exclude;

@Entity
@Table(name = "posts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_gen")
     @SequenceGenerator(name = "post_seq", sequenceName = "post_gen")
     Long id;
     String title;
     String description;
     String image;

     @ManyToOne(cascade = {
             CascadeType.DETACH,
             CascadeType.MERGE,
             CascadeType.REFRESH})
     User user ;

     public Post(Long id, String title, String description, String image, User user) {
          this.id = id;
          this.title = title;
          this.description = description;
          this.image = image;
          this.user = user;
     }

     public Post() {
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }

     public User getUser() {
          return user;
     }

     public void setUser(User user) {
          this.user = user;
     }

     @Override
     public String toString() {
          return "Post{" +
                  "id=" + id +
                  ", title='" + title + '\'' +
                  ", description='" + description + '\'' +
                  ", image='" + image + '\'' +
                  ", user=" + user +
                  '}';
     }
}
