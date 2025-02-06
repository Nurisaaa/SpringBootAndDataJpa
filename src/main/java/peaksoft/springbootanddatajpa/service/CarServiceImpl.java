package peaksoft.springbootanddatajpa.service;

import org.springframework.stereotype.Service;
import peaksoft.springbootanddatajpa.entities.Car;
import peaksoft.springbootanddatajpa.entities.User;
import peaksoft.springbootanddatajpa.repository.CarRepository;
import peaksoft.springbootanddatajpa.repository.UserRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public CarServiceImpl(CarRepository carRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Car> getCarByUseId(Long userId) {
        User user = userRepository.findById(userId).get();
        return user.getCars();
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
