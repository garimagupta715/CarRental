package com.CarRental.model;

import org.springframework.stereotype.Component;

@Component
public class Admin {
    private int id;
    private String AdminName;
    private String No;

    public int getId() {
        return id;
    }

    public String getAdminName() {
        return AdminName;
    }

    public String getNo() {
        return No;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public void setNo(String no) {
        No = no;
    }
}
