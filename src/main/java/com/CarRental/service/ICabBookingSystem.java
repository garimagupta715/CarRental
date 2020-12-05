package com.CarRental.service;

import com.CarRental.Exception.CabNotAvailableException;
import com.CarRental.model.CabRequest;
import com.CarRental.model.CarInfo;

public interface ICabBookingSystem {
    public int getNumofCabsRunning() ;
    public String requestForCab(CabRequest request) throws CabNotAvailableException;
    public void addCab(CarInfo cab);

}
