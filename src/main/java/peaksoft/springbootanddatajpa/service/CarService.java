package peaksoft.springbootanddatajpa.service;

import peaksoft.springbootanddatajpa.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarByUseId(Long userId);

    List<Car> getAllCars();
}
