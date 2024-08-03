package com.android.car.intech.carrentalcompany;

import com.android.car.intech.User;

public interface CarRentalCompany {
    void startMonitoring();
    void stopMonitoring();
    void notifyToUser(User user);
    void registerUser(User user);
    void setCarSpeedLimit(int speedLimit);
}
