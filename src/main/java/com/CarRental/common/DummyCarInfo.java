package com.CarRental.common;

import com.CarRental.model.CarInfo;

import java.util.HashMap;
import java.util.Map;

public class DummyCarInfo {
    public static DummyCarInfo  dummyCarInfo= null;
    public static Map<String, CarInfo> map;
    private DummyCarInfo(){
        map = new HashMap<String,CarInfo>();
    }
    public static DummyCarInfo getInstance(){
        if(dummyCarInfo ==null) {
            dummyCarInfo = new DummyCarInfo();
        }
        return dummyCarInfo;
    }
}
