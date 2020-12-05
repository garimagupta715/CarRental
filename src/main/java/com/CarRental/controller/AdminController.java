package com.CarRental.controller;

import com.CarRental.model.CarInfo;
import com.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private CarService carService;

    @RequestMapping("/show")
    public String show(){
        return "Hello World";
    }

    @GetMapping("/getCarsInfo/{id}")
    public ResponseEntity<CarInfo> getCarsInfo(@PathVariable String id){
        CarInfo carInfo = carService.getCarInfo(id);
        return new ResponseEntity<>(carInfo, HttpStatus.OK);
    }
    @GetMapping("/getAllCarsInfo")
    public ResponseEntity<List<CarInfo>> getCarsInfo(){
        List<CarInfo> carInfo = carService.getAllCarInfo();
        return new ResponseEntity<>(carInfo, HttpStatus.OK);
    }

    @PostMapping("/saveCarsInfo")
    public ResponseEntity<CarInfo> createCarsInfo(@RequestBody CarInfo carInfo){
        CarInfo createdCarInfo = carService.saveCarInfo(carInfo);
        return new ResponseEntity<>(createdCarInfo, HttpStatus.OK);
    }

    @PutMapping("/updateCarsInfo/{id}")
    public ResponseEntity<CarInfo> updateCarsInfo(@PathVariable String id, @RequestBody CarInfo carInfo){
        CarInfo createdCarInfo = carService.updateCarInfo(id,carInfo);
        return new ResponseEntity<>(createdCarInfo, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCarsInfo/{id}")
    public ResponseEntity<String> deleteCarsInfo(@PathVariable String id){
        String response = carService.removeCarInfo(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}