package com.CarRental.repository.impl;

import com.CarRental.common.DummyCarInfo;
import com.CarRental.model.CarInfo;
import com.CarRental.repository.CarInfoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("carInfoRepository")
public class CarInfoRepositoryImpl implements CarInfoRepository {
    @Override
    public CarInfo getCarInfoRep(String id) {
        return (CarInfo) DummyCarInfo.getInstance().map.get(id);
    }

    @Override
    public List<CarInfo> getAllCarInfoRep()
    {
        List<CarInfo> carInfoList = new ArrayList<CarInfo>(DummyCarInfo.getInstance().map.values());
        return carInfoList;
    }

    @Override
    public CarInfo saveCarInfoRep(CarInfo carInfo) {
        return (CarInfo)DummyCarInfo.getInstance().map.put(carInfo.getId(),carInfo);
    }

    @Override
    public CarInfo updateCarInfoRep(String id, CarInfo carInfo) {
        return (CarInfo)DummyCarInfo.getInstance().map.put(carInfo.getId(),carInfo);
    }

    @Override
    public String removeCarInfoRep(String id) {
         DummyCarInfo.getInstance().map.remove(id);
         return "CarInfo: " + id +"successfully deleted from DB";
    }

    @Override
    public int getCarLocation(String id) {
        CarInfo carInfo = DummyCarInfo.getInstance().map.get(id);
        return carInfo.getLocation();
    }
}
