package com.android.car.intech.carrentalcompany.impl;

import com.android.car.intech.carrentalcompany.car.ICar;
import com.android.car.intech.carrentalcompany.SpeedObserver;
import com.android.car.intech.User;
import com.android.car.intech.carrentalcompany.CarRentalCompany;

public class ITRentalServices implements CarRentalCompany, SpeedObserver {
    private User user;
    private int userSpeedLimit = Integer.MAX_VALUE;
    private ICar car;

    public ITRentalServices(ICar car) {
        this.car = car;
        car.registerObserver(this);
    }

    @Override
    public void startMonitoring() {
        if (user != null) {
            user.startCar();
        }
    }

    @Override
    public void stopMonitoring() {
        if (user != null) {
            user.stopCar();
        }
    }

    @Override
    public void notifyToUser(User user) {
        user.alertMessage("Speed limit exceeded!");
    }

    @Override
    public void registerUser(User user) {
        if (this.user == null) {
            this.user = user;
        }
    }

    @Override
    public void notifySpeedExceeded() {
        if (user != null) {
            notifyToUser(user);
        }
    }

    public void setCarSpeedLimit(int speedLimit) {
        car.setSpeedLimit(speedLimit);
    }

    //As of now i implemented the only observer in this class

    // Similarly We can implement the AWS / Firebase listners from here


}
