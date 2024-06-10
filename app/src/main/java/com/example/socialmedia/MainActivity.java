package com.example.socialmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton logIn,signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        w.setBackgroundDrawableResource(R.drawable.bg);
        logIn=findViewById(R.id.log_bt);
        signUp=findViewById(R.id.regis_bt);

        logIn.setOnClickListener(v -> {
            Intent i =new Intent(MainActivity.this,LoginActivity.class);
            startActivity(i);
        });
         signUp.setOnClickListener(v -> {
           Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
           startActivity(intent);
       });
    }
}