package com.mosio.quiclook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Onboarding extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter ;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0 ;
    Button btnGetStarted;
    Animation btnAnim ;
    TextView tvSkip;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        if (restorePrefData()) {
            Intent mainActivity = new Intent(getApplicationContext(),choose_identity.class );
            startActivity(mainActivity);
            finish();
        }

        Window window = Onboarding.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(Onboarding.this, R.color.screen_bg));

        // ini views
        btnNext = findViewById(R.id.btn_next);
        imageView = findViewById(R.id.imageView);
        btnGetStarted = findViewById(R.id.btn_get_started);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        tvSkip = findViewById(R.id.tv_skip);
        // fill list screen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Work from \n" +
                "anywhere ","Track and manage your business and your associates from anywhere in the world.","work.json"));
        mList.add(new ScreenItem("Track, allot and\n" +
                "manage your associates","Check your associates performance, location availability, check in - out, payouts, leave and rewards.","women_and_men.json"));
        mList.add(new ScreenItem("Insights and \n" +
                "Rewards","Track your business progress and reward yourself and associates accordingly.","rewards.json"));

        // setup viewpager
        screenPager =findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);
        // setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);
        // next button click Listner
        btnNext.setOnClickListener(v -> {
            position = screenPager.getCurrentItem();
            if (position < mList.size()) {
                position++;
                screenPager.setCurrentItem(position);
            }
            if (position == mList.size()-1) { // when we rech to the last screen
                // TODO : show the GETSTARTED Button and hide the indicator and the next button
                loaddLastScreen();
            }
        });

        // tablayout add change listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1) {
                    loaddLastScreen();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // Get Started button click listener
        btnGetStarted.setOnClickListener(v -> {
            //open main activity
            Intent mainActivity = new Intent(getApplicationContext(), choose_identity.class);
            startActivity(mainActivity);
            // also we need to save a boolean value to storage so next time when the user run the app
            // we could know that he is already checked the intro screen activity
            // i'm going to use shared preferences to that process
            savePrefsData();
            finish();
        });
        // skip button click listener
        tvSkip.setOnClickListener(v -> screenPager.setCurrentItem(mList.size()));
    }
    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        return pref.getBoolean("isIntroOpnend",false);
    }
    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.apply();
    }
    // show the GETSTARTED Button and hide the indicator and the next button
    private void loaddLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tvSkip.setVisibility(View.INVISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        // TODO : ADD an animation the getstarted button
        // setup animation
        btnGetStarted.setAnimation(btnAnim);
    }
}