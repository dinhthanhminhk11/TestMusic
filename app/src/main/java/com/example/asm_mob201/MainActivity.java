package com.example.asm_mob201;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img, img_new, img_music, img_account;
    TextView tv_name;
    LinearLayout layout_new, layout_music, layout_account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout_new = findViewById(R.id.layout_new);
        layout_music = findViewById(R.id.layout_music);
        layout_account = findViewById(R.id.layout_account);


        img = findViewById(R.id.img);
        tv_name = findViewById(R.id.tv_name);

        layout_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DocBaoActivity.class);
                startActivity(i);
            }
        });

        layout_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NgheNhacActivity.class);
                startActivity(i);
            }
        });

        layout_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        //Animation

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.hieu_ung_img);
        img.startAnimation(animation);

        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.hu_new);
        animatorSet.setTarget(layout_new);
        animatorSet.start();

        AnimatorSet animatorSet1 = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.hu_music);
        animatorSet1.setTarget(layout_music);
        animatorSet1.start();

        AnimatorSet animatorSet2 = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.hu_account);
        animatorSet2.setTarget(layout_account);
        animatorSet2.start();

        AnimatorSet animatorSet3 = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this, R.animator.hu_name);
        animatorSet3.setTarget(tv_name);
        animatorSet3.start();

    }
}