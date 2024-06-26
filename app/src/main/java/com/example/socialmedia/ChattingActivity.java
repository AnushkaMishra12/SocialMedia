package com.example.socialmedia;

import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ChattingActivity extends AppCompatActivity {
    Toolbar back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);
        Window w = getWindow();
        w.setBackgroundDrawableResource(R.color.white);
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());
    }
}