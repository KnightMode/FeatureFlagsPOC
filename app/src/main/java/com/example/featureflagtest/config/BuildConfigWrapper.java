package com.example.featureflagtest.config;

import android.content.Context;
import android.content.SharedPreferences;

public class BuildConfigWrapper {
    private SharedPreferences.Editor editor;
    private SharedPreferences pref;

    public BuildConfigWrapper(Context context) {
        pref = context.getSharedPreferences("MyPref", 0); // 0 - for private mode
    }

    public void setChatBotFeatureFlag(Boolean isEnabled) {
        editor = pref.edit();
        editor.putBoolean(FeatureFlags.CHATBOT, isEnabled);
        editor.apply();
    }

    public boolean isChatBotEnabled() {
        return pref.getBoolean(FeatureFlags.CHATBOT, false);
    }
}
