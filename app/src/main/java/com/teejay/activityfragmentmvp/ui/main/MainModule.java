package com.teejay.activityfragmentmvp.ui.main;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenter;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {

    private MainActivity activity;


    public MainModule(MainActivity activity) {
        this.activity = activity;

    }

    /**
     * Provide MainView
     */
    @Provides
    @Singleton
    public MainView provideMainView() {
        return (MainView) activity;
    }

    /**
     * Provide MainPresenter
     */
    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainView view) {
        return new MainPresenterImpl(view);
    }


}
