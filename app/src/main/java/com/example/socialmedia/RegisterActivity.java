package com.example.socialmedia;

import android.os.Bundle;
import android.view.Window;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    Toolbar back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Window w = getWindow();
        w.setBackgroundDrawableResource(R.color.white);
        back=findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());
    }
}