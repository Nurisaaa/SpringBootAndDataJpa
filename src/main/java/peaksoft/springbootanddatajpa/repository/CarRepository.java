package peaksoft.springbootanddatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.springbootanddatajpa.entities.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarByUser_Id(Long id);
}
