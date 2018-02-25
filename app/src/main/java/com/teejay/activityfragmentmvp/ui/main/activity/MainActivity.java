package com.teejay.activityfragmentmvp.ui.main.activity;

import android.os.Bundle;


import com.teejay.activityfragmentmvp.ui.main.fragments.*;
import com.teejay.activityfragmentmvp.AppModule;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.ui.common.BaseActivity;
import com.teejay.activityfragmentmvp.ui.main.DaggerMainComponent;
import com.teejay.activityfragmentmvp.ui.main.FragmentCallback;
import com.teejay.activityfragmentmvp.ui.main.MainComponent;
import com.teejay.activityfragmentmvp.ui.main.MainModule;
import com.teejay.activityfragmentmvp.ui.main.presenters.MainPresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.MainView;

import android.support.design.widget.BottomNavigationView;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements MainView,
        FragmentCallback
         {

    @Inject
    MainPresenterImpl presenter;


    private MainComponent mainComponent;


    public MainComponent getActivityComponent() {
        if (mainComponent == null) {
            mainComponent = DaggerMainComponent.builder()
                    .appModule(new AppModule(getApplication()))
                    .mainModule(new MainModule(this))
                    .build();
        }
        return mainComponent;
    }


             @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load ArtistsFragment
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SampleFragment.newInstance()).commit();


        getActivityComponent().inject(this);



    }




    @Override
    public void finishProcess() {
        finish();
    }



    @Override
    public void showAlbumFragment() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, SampleFragment.newInstance()).commit();
    }





}
