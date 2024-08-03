package com.android.car.intech.carrentalcompany.car;

import com.android.car.intech.carrentalcompany.SpeedObserver;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

public class VolvoCar implements ICar {
    private SpeedObserver mObserver;
    private int speedLimit;
    private int currentSpeed = 80;

    // Constructor
    public VolvoCar() {
    }

    @Override
    public void registerObserver(SpeedObserver observer) {
        mObserver = observer;
    }

    @Override
    public void unregisterObserver(SpeedObserver observer) {
        mObserver = null;
    }

    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped.");
    }

    @Override
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int speed) {    // We can Implement the car current speed logic and there we should invoke this method
        this.currentSpeed = speed;
        if (currentSpeed > speedLimit) {
            notifyObservers();
        }
    }

    private void notifyObservers() {
        if (mObserver != null) {
            mObserver.notifySpeedExceeded();
            sendFirebaseNotification();
        }
    }

    private void sendFirebaseNotification() {
        Message message = Message.builder()
                .setNotification(new Notification("Speed Limit Exceeded", "Your car has exceeded the speed limit."))
                .setTopic("speedAlerts")
                .build();

        // Send the message
        FirebaseMessaging.getInstance().sendAsync(message).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                System.out.println("Notification sent successfully.");
            } else {
                System.err.println("Notification sending failed: " + task.getException().getMessage());
            }
        });
    }

    private void sendAwsNotification() {
        // Similarly AWS client notification logic
    }
}
