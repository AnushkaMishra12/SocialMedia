package com.example.socialmedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {

    Toolbar back;

    MaterialButton login_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);
        Window w = getWindow();
        w.setBackgroundDrawableResource(R.color.white);
        back=findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        login_bt=findViewById(R.id.login_bt);
        login_bt.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this,DashBoardActivity.class);
            startActivity(i);
        });


    }
}