package com.CarRental.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CabRequest {
    private  String bookingId;
    private  int pickupCode;
    private  int dropCode;
    private  Date pickupTime;

    public String getBookingId() {
        return bookingId;
    }

    public int getPickupCode() {
        return pickupCode;
    }

    public int getDropCode() {
        return dropCode;
    }

    public Date getPickupTime() {
        return (Date) pickupTime.clone();
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setPickupCode(int pickupCode) {
        this.pickupCode = pickupCode;
    }

    public void setDropCode(int dropCode) {
        this.dropCode = dropCode;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }
}
