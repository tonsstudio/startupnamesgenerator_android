package com.tonsstudio.startupgeneratorname;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GenerateActivity extends AppCompatActivity {

    @Bind(R.id.activity_generate_tiet)
    TextInputEditText activityGenerateTiet;
    @Bind(R.id.activity_generate_btn)
    Button activityGenerateBtn;
    @Bind(R.id.activity_generate_logo_iv)
    ImageView activityGenerateLogoIv;
    @Bind(R.id.acitivty_generate_tv)
    TextView acitivtyGenerateTv;
    @Bind(R.id.activity_generate_til)
    TextInputLayout activityGenerateTil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (activityGenerateLogoIv != null) {
            activityGenerateLogoIv.clearAnimation();
        }
        activityGenerateTiet.setText("");
        activityGenerateTiet.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (activityGenerateLogoIv.getAlpha() == 0) {
                    activityGenerateLogoIv.animate().setDuration(250).alpha(1).setInterpolator(new AccelerateDecelerateInterpolator()).start();
                }
                if (acitivtyGenerateTv.getAlpha() == 0) {
                    acitivtyGenerateTv.animate().setDuration(650).setStartDelay(500).alpha(1).setInterpolator(new DecelerateInterpolator()).start();
                }

                acitivtyGenerateTv.setVisibility(View.VISIBLE);
                activityGenerateBtn.animate().setDuration(650).setStartDelay(800).alpha(1).setInterpolator(new DecelerateInterpolator()).start();
                activityGenerateTil.animate().setDuration(650).setStartDelay(900).alpha(1).setInterpolator(new DecelerateInterpolator()).start();
            }
        }, 100);
    }

    @OnClick(R.id.activity_generate_btn)
    public void onClick() {
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        activityGenerateLogoIv.startAnimation(anim);

        activityGenerateTiet.postDelayed(new Runnable() {
            @Override
            public void run() {

                activityGenerateBtn.animate().setDuration(250).alpha(0).start();
                activityGenerateTil.animate().setDuration(350).setStartDelay(200).alpha(0).start();
                acitivtyGenerateTv.animate().setDuration(350).setStartDelay(400).alpha(0).start();
                activityGenerateLogoIv.animate().setDuration(350).setStartDelay(1150).alpha(0).start();

                activityGenerateTiet.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(GenerateActivity.this, NamesActivity.class);
                        i.putExtra("name", activityGenerateTiet.getText().toString().trim());
                        startActivity(i);
                        overridePendingTransition(0, 0);
                    }
                }, 1500);

            }
        }, 3000);

    }
}
