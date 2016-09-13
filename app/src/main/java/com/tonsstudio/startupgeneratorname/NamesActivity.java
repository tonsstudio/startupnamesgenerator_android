package com.tonsstudio.startupgeneratorname;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NamesActivity extends AppCompatActivity {

    public static final String TAG = NamesActivity.class.getName();

    NamesAdapter adapter;

    @Bind(R.id.activity_names_rv)
    RecyclerView activityNamesRv;
    @Bind(R.id.activity_names_back_btn)
    ImageButton activityNamesBackBtn;

    ArrayList<String> gn = new ArrayList<>();
    String name = "startup";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        ButterKnife.bind(this);

        activityNamesRv.animate().setDuration(350).setStartDelay(200).alpha(1).start();
        activityNamesBackBtn.animate().setDuration(350).setStartDelay(600).alpha(1).start();

        name = getIntent().getExtras().getString("name");
        adapter = new NamesAdapter(gn);
        generateNames();

        activityNamesRv.setAdapter(adapter);
        activityNamesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void generateNames() {
        gn.add(name + "er");
        gn.add(name + "s");
        gn.add(name + "ly");
        gn.add(name + "by");
        gn.add(name + "ser");
        gn.add(name + "no");
        gn.add(name + "le");
        gn.add(name + "fy");
        gn.add(name + "ee");
        gn.add(name + "a");
        gn.add(name + "e");
        gn.add(name + "i");
        gn.add(name + "o");
        gn.add(name + "u");
        gn.add(name + "s");
        gn.add(name + "r");
        gn.add(name + "y");
        gn.add(name + "ae");
        gn.add(name + "ar");
        gn.add(name + "um");
        gn.add(name + "ic");
        gn.add(name + "it");
        gn.add(name + "tu");
        gn.add(name + "on");
        gn.add(name + "us");
        gn.add(name + "bi");
        gn.add(name + "or");
        gn.add(name + "or");
        gn.add(name + "ba");
        gn.add(name + "bu");
        gn.add(name + "bly");
        gn.add(name + "po");
        gn.add(name + "tu");

        gn.add("max" + name);
        gn.add("tu" + name);

        gn.add(name.replaceAll("[aeiou]", ""));

        if (name.matches(".*(?i)[aeiou]")) {
            Log.d(TAG, "generateNames: " + name + " ends on a vowel");
        } else {
            Log.d(TAG, "generateNames: " + name + " not ends on a vowel");

        }
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.activity_names_back_btn)
    public void onClick() {
        activityNamesRv.animate().setDuration(350).alpha(0).start();
        activityNamesBackBtn.animate().setDuration(350).setStartDelay(300).alpha(0).start();

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                overridePendingTransition(0, 0);
            }
        }, 1000);

    }

}
