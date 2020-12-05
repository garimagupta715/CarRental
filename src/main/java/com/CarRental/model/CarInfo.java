package com.CarRental.model;

import com.CarRental.util.CabSystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
@Scope(value="prototype")
public class CarInfo {
    private final String id;
    private int location;
    private Date availableFrom;

    @Autowired
    private final List<CabRequest> requests;


    public CarInfo(String num, int location) {
        this.id = num;
        this.location = location;
        Calendar cal = Calendar.getInstance();
        this.availableFrom = cal.getTime();
        this.requests = new ArrayList<>();
    }

    public int getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    public List<CabRequest> getRequestsServed() {
        return requests;
    }


    public int hashCode() {
        return id.hashCode();
    }

    public boolean equals(Object that) {
        if (that instanceof CarInfo) {
            CarInfo _that = (CarInfo) that;
            return this.id.equals(_that.id);
        } else {
            return false;
        }
    }


    public Date getAvailableFrom() {
        return (Date) availableFrom.clone();
    }

    private void addJourneyMinutes(Date pickUpTime, int minutes) {
        final long ONE_MINUTE_IN_MILLIS = 60000;
        long curTimeInMs = pickUpTime.getTime();
        this.availableFrom = new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
    }

    public boolean gotTimeToServeThis(CabRequest request) {
        int timeToReach = getTimeToReach(request);
        Date currentTime = addMinutesToDate(timeToReach, this.getAvailableFrom());
        Date pickUpTime = request.getPickupTime();
        int spareTime = (int) (pickUpTime.getTime() - currentTime.getTime()) / (1000 * 60);
        return spareTime >= 15;
    }

    private int getTimeToReach(CabRequest request) {
        int distance = Math.abs(this.getLocation() - request.getPickupCode()) * CabSystemConstants.DISTANCE_BETWEEN_LOCATIONS;
        return distance * CabSystemConstants.TIME_FOR_KM;
    }

    private int getTimeForDrive(CabRequest request) {
        int distance = Math.abs(request.getPickupCode() - request.getDropCode()) * CabSystemConstants.DISTANCE_BETWEEN_LOCATIONS;
        return distance * CabSystemConstants.TIME_FOR_KM;
    }

    private static Date addMinutesToDate(int minutes, Date beforeTime) {
        final long ONE_MINUTE_IN_MILLIS = 60000;
        long curTimeInMs = beforeTime.getTime();
        return new Date(curTimeInMs + (minutes * ONE_MINUTE_IN_MILLIS));
    }

    public double getProfit(CabRequest request) {
        int distance = Math.abs(this.getLocation() - request.getPickupCode()) * CabSystemConstants.DISTANCE_BETWEEN_LOCATIONS;
        double costInCurred = distance * CabSystemConstants.COMPANY_COST;
        int travelDistance = Math.abs(request.getPickupCode() - request.getDropCode());
        costInCurred += travelDistance * CabSystemConstants.COMPANY_COST;
        double costCollected = travelDistance * CabSystemConstants.FARE;
        return ((costCollected - costInCurred) / costInCurred) * 100;
    }


    public void addJourney(CabRequest request) {
        addJourneyMinutes(request.getPickupTime(), getTimeForDrive(request));
        this.location = request.getDropCode();
        requests.add(request);

    }
}
