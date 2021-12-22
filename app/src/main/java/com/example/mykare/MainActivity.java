package com.example.mykare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button registerloginpage;
    TextView forgotpassword;
    private TextInputLayout email2,password2;
    Button login;
    SharedPreferences ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email2=findViewById(R.id.email2);
        password2=findViewById(R.id.password2);

        ref=getSharedPreferences("myapp",MODE_PRIVATE);

        boolean check = ref.getBoolean("login",false);

        if (check)
        {
            Intent intent=new Intent(MainActivity.this,WelcomePage.class);
            startActivity(intent);
        }

        login=findViewById(R.id.loginpage_button);
        forgotpassword=findViewById(R.id.forgotpassword_login);
        registerloginpage=findViewById(R.id.register_loginpage);



        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ForgetPassword.class);
                startActivity(intent);
            }
        });


        registerloginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });
    }




    public void Login(View view)
    {
        String sEmail=ref.getString("email","");
        String sPassword=ref.getString("password","");

        if (sEmail.equals(email2.getEditText().getText().toString()) && sPassword.equals(password2.getEditText().getText().toString()))
        {
            ref.edit().putBoolean("login",true).apply();

            Intent intent=new Intent(MainActivity.this,WelcomePage.class);
            startActivity(intent);
        }

        else
        {
            Toast.makeText(this, "Invalid User", Toast.LENGTH_SHORT).show();
        }


    }

}