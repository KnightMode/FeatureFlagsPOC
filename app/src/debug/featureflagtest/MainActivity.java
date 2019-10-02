package com.example.featureflagtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BuildConfigWrapper buildConfigWrapper = new BuildConfigWrapper(this);
        setContentView(R.layout.debug_activity);
        textView = findViewById(R.id.text_field);
        buildConfigWrapper.setChatBotFeatureFlag(false);
        if (buildConfigWrapper.isChatBotEnabled()) {
            textView.setText("This is from feature flag");
        } else {
            textView.setText("This is without feature flag");
        }
    }
}
