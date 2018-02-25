package com.teejay.activityfragmentmvp.util;

import com.teejay.activityfragmentmvp.retrofit.Restapi;
import com.teejay.activityfragmentmvp.retrofit.RetrofitClient;

/**
 * Created by tjaved on 2/25/18.
 */
public class ApiUtils {

    public static final String BASE_URL = "https://mobile-code-test.ifactornotifi.com/json/";

    public static Restapi getRestService() {
        return RetrofitClient.getClient(BASE_URL).create(Restapi.class);
    }
}
