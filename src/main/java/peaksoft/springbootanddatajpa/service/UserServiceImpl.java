package peaksoft.springbootanddatajpa.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.springbootanddatajpa.entities.Car;
import peaksoft.springbootanddatajpa.entities.User;
import peaksoft.springbootanddatajpa.repository.CarRepository;
import peaksoft.springbootanddatajpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(User user, Long id) {
        User user1 = userRepository.findById(id).get();
        userRepository.save(user1);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void assignCarToUser(Long userId, Long carId) {
        User user = userRepository.findById(userId).get();
        Car car = carRepository.findById(carId).get();
        car.setUser(user);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        user.setCars(cars);
    }
}
