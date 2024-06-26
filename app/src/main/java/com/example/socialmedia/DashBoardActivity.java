package com.example.socialmedia;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoardActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Window window = getWindow();
        window.setBackgroundDrawableResource(R.color.white);
        coordinatorLayout = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.mHome);
    }
    HomeFragment firstFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    SearchFragment searchFragment = new SearchFragment();
    ChatFragment chatFragment = new ChatFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.mHome:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, firstFragment)
                        .commit();
                return true;
            case R.id.mProfile:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, profileFragment)
                        .commit();
                return true;
            case R.id.mSearch:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, searchFragment)
                        .commit();
                return true;
            case R.id.mChat:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, chatFragment)
                        .commit();
                return true;
        }
        return false;
    }
}