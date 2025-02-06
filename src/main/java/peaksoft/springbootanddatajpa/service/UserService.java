package peaksoft.springbootanddatajpa.service;

import peaksoft.springbootanddatajpa.entities.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void delete(Long id);
    void update(User user, Long id);
    User findById(Long id);
    List<User> getAll();

    void assignCarToUser(Long userId, Long carId);
}
