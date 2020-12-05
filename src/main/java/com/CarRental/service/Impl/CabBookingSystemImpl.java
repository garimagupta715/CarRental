package com.CarRental.service.Impl;

import com.CarRental.Exception.CabNotAvailableException;
import com.CarRental.model.CabRequest;
import com.CarRental.model.CarInfo;
import com.CarRental.service.ICabBookingSystem;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CabBookingSystemImpl implements ICabBookingSystem {
    private Set<CarInfo> availableCabs = new HashSet<>();

    @Override
    public void addCab(CarInfo cab) {
        availableCabs.add(cab);
    }

    @Override
    public String requestForCab(CabRequest request) throws CabNotAvailableException {

        CarInfo selectedCab = null;
        double maxProfit = 0;
        for (CarInfo cab : availableCabs) {
            if (cab.gotTimeToServeThis(request)) {
                double profit = cab.getProfit(request);
                if (profit > 20 && profit > maxProfit) {
                    selectedCab = cab;
                    maxProfit = profit;
                }
            }
        }

        if (selectedCab != null) {
            selectedCab.addJourney(request);
            return selectedCab.getId();
        } else {
            throw new CabNotAvailableException("No Cab Available");
        }
    }

    @Override
    public int getNumofCabsRunning() {
        return availableCabs.size();
    }
}
