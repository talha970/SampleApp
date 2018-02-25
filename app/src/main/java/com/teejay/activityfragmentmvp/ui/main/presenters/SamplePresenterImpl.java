package com.teejay.activityfragmentmvp.ui.main.presenters;

import android.util.Log;

import com.teejay.activityfragmentmvp.data.DataManager;
import com.teejay.activityfragmentmvp.data.model.Users;
import com.teejay.activityfragmentmvp.retrofit.Restapi;
import com.teejay.activityfragmentmvp.ui.main.views.SampleView;
import com.teejay.activityfragmentmvp.util.ApiUtils;
import com.teejay.activityfragmentmvp.util.PermissionManager;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by tjaved on 2/2/18.
 */

public class SamplePresenterImpl implements SamplePresenter {
    private SampleView view;
    private Restapi retrofit;
    @Inject
    PermissionManager permissionManager;

    @Inject
    DataManager dataManager;



    private boolean permissionGranted;
    List<Users> MyData;
    @Inject
    public SamplePresenterImpl() {

    }

    @Override
    public void init(SampleView view) {
        this.view = view;
        retrofit= ApiUtils.getRestService();

    }




    @Override
    public void loadUsers() {


        //Enque the call
        retrofit.getUsers().enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {
                if(response.isSuccessful()) {

                    Log.d("MainActivity", response.body().toString());
                    view.showData(response.body());
                }else {
                    int statusCode  = response.code();
                    Log.d("MainActivity", response.message() + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {

                Log.d("MainActivity", "error loading from API");

            }
        });


    }




}