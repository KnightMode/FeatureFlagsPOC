package com.example.featureflagtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.featureflagtest.config.BuildConfigWrapper;
import com.example.featureflagtest.config.DemoApplication;

import javax.inject.Inject;

public class DebugActivity extends AppCompatActivity {

    @Inject
    BuildConfigWrapper buildConfigWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((DemoApplication) getApplication()).component().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug_activity);
    }

    public void onCheckboxClicked(View view) {
        buildConfigWrapper.setChatBotFeatureFlag(true);
    }

    public void onNextClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
