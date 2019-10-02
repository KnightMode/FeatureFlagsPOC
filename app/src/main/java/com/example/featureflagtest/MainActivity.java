package com.example.featureflagtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.featureflagtest.config.BuildConfigWrapper;
import com.example.featureflagtest.config.DemoApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    BuildConfigWrapper buildConfigWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((DemoApplication) getApplication()).component().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        TextView textView = findViewById(R.id.text_field);
        if (buildConfigWrapper.isChatBotEnabled()) {
            textView.setText("This is the text with feature flag enabled");
        }
    }
}
