package com.android.car.intech.carrentalcompany.car;

import com.android.car.intech.carrentalcompany.SpeedObserver;

public interface ICar {
    void registerObserver(SpeedObserver observer);
    void unregisterObserver(SpeedObserver observer);
    void start();
    void stop();
    void setSpeedLimit(int speedLimit);
    int getCurrentSpeed();
}
