package com.teejay.activityfragmentmvp.retrofit;

import com.teejay.activityfragmentmvp.data.model.Post;
import com.teejay.activityfragmentmvp.data.model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tjaved on 2/25/18.
 */

public interface Restapi {
    @GET("users")
    Call<List<Users>> getUsers();

    @GET("posts?")
    Call<List<Post>> getPosts(@Query("userId") String userId);
}
