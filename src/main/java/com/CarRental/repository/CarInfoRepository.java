package com.CarRental.repository;

import com.CarRental.model.CarInfo;

import java.util.List;

public interface CarInfoRepository {
    public CarInfo getCarInfoRep(String id);
    public List<CarInfo> getAllCarInfoRep();
    public CarInfo saveCarInfoRep(CarInfo carInfo);
    public CarInfo updateCarInfoRep(String id, CarInfo carInfo);
    public String removeCarInfoRep(String id);
    int getCarLocation(String id);
}
