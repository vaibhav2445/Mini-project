package com.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.car.model.Car;
import com.car.repositary.*;
@RestController
@RequestMapping("/api")
public class CarController {
	@Autowired
    private CarRepository carRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewCar(@RequestBody Car car) {
        carRepository.saveAll(car);
        return "Car saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Car getCarById(@PathVariable Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateCar(@PathVariable Long id, @RequestBody Car newCar) {
        Car car = carRepository.findAllById(id).orElse(null);
        if (car == null) {
            return "Car not found";
        }
        car.setBrand(newCar.getBrand());
        car.setColor(newCar.getColor());
        car.setPrice(newCar.getPrice());
        carRepository.saveAll(car);
        return "Car updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteCar(@PathVariable Long id) {
        carRepository.deleteAllById(id);
        return "Car deleted";
    }
}
