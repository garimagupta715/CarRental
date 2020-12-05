package com.CarRental.common;

import com.CarRental.model.CarInfo;

import java.util.HashMap;
import java.util.Map;

public class DummyCabRequest {
    public static DummyCabRequest  dummyCabRequest= null;
    public static Map<String, CarInfo> map;
    private DummyCabRequest(){
        map = new HashMap<String,CarInfo>();
    }
    public static DummyCabRequest getInstance(){
        if(dummyCabRequest ==null) {
            dummyCabRequest = new DummyCabRequest();
        }
        return dummyCabRequest;
    }
}
