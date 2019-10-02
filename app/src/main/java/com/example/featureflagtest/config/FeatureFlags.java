package com.example.featureflagtest.config;

import android.support.annotation.StringDef;

import static com.example.featureflagtest.config.FeatureFlags.CHATBOT;

@StringDef({CHATBOT})
public @interface FeatureFlags {
    public static final String CHATBOT = "chatbot";
}
