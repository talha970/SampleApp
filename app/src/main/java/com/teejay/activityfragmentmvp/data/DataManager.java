package com.teejay.activityfragmentmvp.data;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by tjaved on 1/28/18.
 */

public class DataManager {

    Context context;


    @Inject
    public DataManager(Context context) {
        this.context = context;
    }

}
