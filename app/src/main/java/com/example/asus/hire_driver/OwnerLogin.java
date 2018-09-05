package com.example.asus.hire_driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class OwnerLogin extends AppCompatActivity {

    private Button btnprev, btndone;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        btndone = (Button) findViewById(R.id.btndone_own);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_own);



        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.own_pop,null);

                popupWindow = new PopupWindow(container,800,400,true);
                popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY,200,1300);

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

            }
        });



    }


}
