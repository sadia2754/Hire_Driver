package com.example.asus.hire_driver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class DriverLogin extends AppCompatActivity {

    private Button  btndonedriv;
    private EditText eml, pass, conpass;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;


    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);

        btndonedriv = (Button) findViewById(R.id.btndone_driv);
        eml = (EditText) findViewById(R.id.emailtxt);
        pass = (EditText) findViewById(R.id.passtxt);
        conpass = (EditText) findViewById(R.id.conpasstxt);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_driv);




        btndonedriv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openHome();
                    }
                },5000);

            }
        });


    }

    public void registerUser(){
        String email = eml.getText().toString().trim();
        String passwrd = pass.getText().toString().trim();
        String confirmpass = conpass.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(passwrd)){
            Toast.makeText(this, "Please enter Password",Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registeing User...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,passwrd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(DriverLogin.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }
                        else
                        {
                            Toast.makeText(DriverLogin.this, "Please try again", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });




    }

    public void openHome()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
