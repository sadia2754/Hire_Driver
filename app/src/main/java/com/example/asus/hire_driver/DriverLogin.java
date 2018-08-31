package com.example.asus.hire_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DriverLogin extends AppCompatActivity {

    private Button btnprevdriv, btndonedriv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        btndonedriv = (Button) findViewById(R.id.btndone_driv);

    }


}
