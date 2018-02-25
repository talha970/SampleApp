package com.teejay.activityfragmentmvp.ui.main.views;

import com.teejay.activityfragmentmvp.data.model.Users;

import java.util.List;

/**
 * Created by tjaved on 2/2/18.
 */

public interface SampleView {


    void showEmpty();
    void showData(List<Users> data);
}
