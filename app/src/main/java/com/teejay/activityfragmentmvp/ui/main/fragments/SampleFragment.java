package com.teejay.activityfragmentmvp.ui.main.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Users;
import com.teejay.activityfragmentmvp.ui.common.BaseFragment;
import com.teejay.activityfragmentmvp.ui.main.FragmentCallback;
import com.teejay.activityfragmentmvp.ui.main.activity.MainActivity;
import com.teejay.activityfragmentmvp.ui.main.activity.PostsActivity;
import com.teejay.activityfragmentmvp.ui.main.adapters.SampleAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;
import com.teejay.activityfragmentmvp.ui.main.presenters.SamplePresenterImpl;
import com.teejay.activityfragmentmvp.ui.main.views.SampleView;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleFragment extends BaseFragment implements SampleView, OnRecycleObjectClickListener<Users> {
    private static final String TAG = "SampleFragment";
    @Inject
    SamplePresenterImpl presenter;

    @Inject
    SampleAdapter sampleAdapter;



    private FragmentCallback callback;

    private View view;

    @BindView(R.id.sample_recycler_view) RecyclerView mRecyclerView;


    public static SampleFragment newInstance() {
        return new SampleFragment();
    }

    public SampleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).getActivityComponent().inject(this);


        presenter.init(this);
        presenter.loadUsers();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_samples, container, false);
        ButterKnife.bind(this,view);
        sampleAdapter.setListener(this);
        mRecyclerView.setAdapter(sampleAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Bit naughty but we know it will work!
        callback = (FragmentCallback) activity;
    }

    /**
     * View implementation
     */


    @Override
    public void showEmpty() {
        sampleAdapter.setItems(Collections.<Users>emptyList());
        sampleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showData(List<Users> data) {
        if(!data.isEmpty()) {
            Log.d(TAG, String.valueOf(data.size()));
            sampleAdapter.setItems(data);
            sampleAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void OnItemClick(Users item) {

       
        Intent myIntent = new Intent(getActivity(), PostsActivity.class);
        myIntent.putExtra("key", item.getId()); //Optional parameters
        getActivity().startActivity(myIntent);


    }
}
