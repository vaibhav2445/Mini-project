package com.car.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.car.model.Car;

public interface CarRepository extends CrudRepository<Car, Long>,JpaRepository<Car , Long>{

	Optional<Car> findAllById(Long id);
	void deleteAllById(Long id);
	void saveAll(Car car);

	

}
