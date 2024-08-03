package com.android.car.intech;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;  // Updated import statement
import android.widget.TextView;

import com.android.car.intech.carrentalcompany.CarRentalCompany;
import com.android.car.intech.carrentalcompany.car.ICar;
import com.android.car.intech.carrentalcompany.car.VolvoCar;
import com.android.car.intech.carrentalcompany.impl.ITRentalServices;

public class MainActivity extends AppCompatActivity {

    private CarRentalCompany itRental;
    private ICar volvoCar;
    private TextView alertMessagesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Some hardcoded code to execution
        volvoCar = new VolvoCar();
        itRental = new ITRentalServices(volvoCar);
        User user = new User("1", "Raj", "1234567890", volvoCar);
        itRental.registerUser(user);
        itRental.startMonitoring();
        itRental.setCarSpeedLimit(60);
        itRental.stopMonitoring();
    }
}
