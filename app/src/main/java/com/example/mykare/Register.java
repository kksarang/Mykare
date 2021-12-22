package com.example.mykare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {


    Button alredyaccount, signupbutton;
    private TextInputLayout  fullname, email, password, number;
    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        alredyaccount = findViewById(R.id.alredyaccount);
        signupbutton = findViewById(R.id.register_button);
        fullname = findViewById(R.id.fullname1);
        email = findViewById(R.id.email1);
        password = findViewById(R.id.password1);
        number = findViewById(R.id.number1);

        alredyaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });


        ref = getSharedPreferences("myapp",MODE_PRIVATE);


    }
        public void signUp(View view)
        {
            String name=fullname.getEditText().getText().toString();
            String emil=email.getEditText().getText().toString();
            String num=number.getEditText().getText().toString();
            String pass=password.getEditText().getText().toString();

            ref.edit().putString("name",name).apply();
            ref.edit().putString("email",emil).apply();

            ref.edit().putString("number",num).apply();
            ref.edit().putString("password",pass).apply();

            ref.edit().putBoolean("login",true).apply();


            Intent i = new Intent(Register.this,WelcomePage.class);

            startActivity(i);





        }


    }
