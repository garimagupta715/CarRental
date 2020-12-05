package com.CarRental.service;

import com.CarRental.model.CarInfo;
import com.CarRental.model.CabRequest;

import java.util.List;

public interface CarService {
    public CarInfo getCarInfo(String id);
    public List<CarInfo> getAllCarInfo();
    public CarInfo saveCarInfo(CarInfo carInfo);
    public CarInfo updateCarInfo(String id, CarInfo carInfo);
    public String removeCarInfo(String id);
    public int getLocation(String id);
    public CarInfo bookCab(CabRequest use);

}
