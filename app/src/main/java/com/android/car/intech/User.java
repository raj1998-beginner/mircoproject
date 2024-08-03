package com.android.car.intech;

import android.util.Log;

import com.android.car.intech.carrentalcompany.car.ICar;

public class User {
    private String userId;
    private String userName;
    private String phoneNumber;
    private ICar car;
    private String alertMessages;

    // Constructor
    public User(String userId, String userName, String phoneNumber, ICar carModel) {
        this.userId = userId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.car = carModel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void alertMessage(String message){
        Log.d("Notification" , message);

    }
    public void startCar() {
        car.start();
    }

    public void stopCar() {
        car.stop();
    }
}
