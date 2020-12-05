package com.CarRental.controller;

import com.CarRental.Exception.CabNotAvailableException;
import com.CarRental.model.CabRequest;
import com.CarRental.model.CarInfo;
import com.CarRental.service.CarService;
import com.CarRental.service.ICabBookingSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CarService carService;
    @Autowired
    ICabBookingSystem cabBookingSystem;

    @GetMapping("/getLocation{id}")
    public ResponseEntity<Integer> getCarLocation(@PathVariable String id){
        int location =  carService.getLocation(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/bookCab")
    public ResponseEntity bookCab(@RequestBody CabRequest cabRequest) throws CabNotAvailableException {
        String cabAvailable = cabBookingSystem.requestForCab(cabRequest);
        return new ResponseEntity<>(cabAvailable, HttpStatus.OK);
    }
    }
