package com.example.featureflagtest.config;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AndroidModule {
    private final DemoApplication application;

    AndroidModule(DemoApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    BuildConfigWrapper buildConfigWrapper(Context context) {
        return new BuildConfigWrapper(context);
    }
}