package com.teejay.activityfragmentmvp.ui.main.presenters;


import com.teejay.activityfragmentmvp.ui.common.BaseFragmentPresenter;
import com.teejay.activityfragmentmvp.ui.main.views.SampleView;

public interface SamplePresenter extends BaseFragmentPresenter<SampleView> {

    void loadUsers();

}
