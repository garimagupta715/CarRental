package com.CarRental.service.Impl;

import com.CarRental.model.CarInfo;
import com.CarRental.model.CabRequest;
import com.CarRental.repository.CarInfoRepository;
import com.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carInfoService")
public class CarServiceImpl implements CarService {
    @Autowired
    CarInfoRepository carInfoRepository ;
    @Override
    public CarInfo getCarInfo(String id) {
        return carInfoRepository.getCarInfoRep(id);
    }

    @Override
    public List<CarInfo> getAllCarInfo() {
        return carInfoRepository.getAllCarInfoRep();
    }

    @Override
    public CarInfo saveCarInfo(CarInfo carInfo) {
        return carInfoRepository.saveCarInfoRep(carInfo);
    }

    @Override
    public CarInfo updateCarInfo(String id, CarInfo carInfo) {
        return carInfoRepository.updateCarInfoRep(id,carInfo);
    }

    @Override
    public String removeCarInfo(String id) {
        return carInfoRepository.removeCarInfoRep(id);
    }

    @Override
    public int getLocation(String id) {
        return carInfoRepository.getCarLocation(id);
    }

    @Override
    public CarInfo bookCab(CabRequest user) {
        return null;
    }
}
