package com.tonsstudio.startupgeneratorname;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.activity_main_logo_iv)
    ImageView activityMainLogoIv;
    @Bind(R.id.activity_main_fl)
    FrameLayout activityMainFl;
    @Bind(R.id.activity_main_new_fl)
    FrameLayout activityMainNewFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        activityMainLogoIv.animate().alpha(1).setStartDelay(200).setDuration(500).start();

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        activityMainLogoIv.startAnimation(anim);
        activityMainLogoIv.postDelayed(new Runnable() {
            @Override
            public void run() {
                activityMainLogoIv.clearAnimation();
            }
        }, 3000);
        activityMainNewFl.animate().alpha(1).setStartDelay(3000).setDuration(500).start();

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, GenerateActivity.class);
                startActivity(i);
                overridePendingTransition(0, 0);

            }
        }, 4000);
    }
}
