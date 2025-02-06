package peaksoft.springbootanddatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springbootanddatajpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
