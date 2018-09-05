package com.example.asus.hire_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btndrivreg,btnownreg,btnmember ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndrivreg = (Button) findViewById(R.id.btndriver);
        btnownreg = (Button) findViewById(R.id.btnowner);
        btnmember = (Button) findViewById(R.id.regmember);
        btndrivreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDriverLogin();
            }
        });

        btnownreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOwnerLogin();
            }
        });

        btnmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMemberReg();
            }
        });


    }

    public void openDriverLogin(){
        Intent intent = new Intent(this, DriverLogin.class);
        startActivity(intent);
    }

    public void openOwnerLogin(){
        Intent intent = new Intent(this, OwnerLogin.class);
        startActivity(intent);
    }

    public void openMemberReg(){
        Intent intent = new Intent(this, MemberLogin.class);
        startActivity(intent);

    }
}
