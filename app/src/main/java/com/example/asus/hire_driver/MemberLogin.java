package com.example.asus.hire_driver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MemberLogin extends AppCompatActivity {

    private  Button btnloginmem;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private EditText usrname, usrpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_login);

        btnloginmem = (Button) findViewById(R.id.btnlogin_mem);
        usrpass = (EditText) findViewById(R.id.passwrdtxt);
        usrname = (EditText) findViewById(R.id.usrnametxt);


        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        btnloginmem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginuser();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openAddPage();
                    }
                },5000);

            }
        });
    }


    public void loginuser(){
        String email = usrname.getText().toString().trim();
        String passwrd = usrpass.getText().toString().trim();

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

        firebaseAuth.signInWithEmailAndPassword(email, passwrd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(MemberLogin.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }
                        else
                        {
                            Toast.makeText(MemberLogin.this, "Please try again", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                });




    }

    public void openAddPage(){
        Intent intent = new Intent(this, AddPage.class);
        startActivity(intent);
    }
}
