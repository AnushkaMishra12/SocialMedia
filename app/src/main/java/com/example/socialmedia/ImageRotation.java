package com.example.socialmedia;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageRotation extends AppCompatActivity {

    private ImageView imageView;
    private GestureDetector gestureDetector;
    private Camera camera;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_rotation);

        imageView = findViewById(R.id.imageView);
        camera = new Camera();

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float rotationY = imageView.getRotationY() - distanceX;
                imageView.setRotationY(rotationY);
                return true;
            }

            @Override
            public boolean onDown(MotionEvent e) {
                return true;
            }
        });

        imageView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        start3DRotationAnimation();
    }

    private void start3DRotationAnimation() {
        ObjectAnimator rotationY = ObjectAnimator.ofFloat(imageView, "rotationY", 0f, 360f);
        rotationY.setDuration(4000);
        rotationY.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationY.setRepeatCount(ObjectAnimator.INFINITE);
        rotationY.setRepeatMode(ObjectAnimator.RESTART);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(rotationY);
        animatorSet.start();
    }
}
