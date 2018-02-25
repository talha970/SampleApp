package com.teejay.activityfragmentmvp.ui.main.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Post;

import com.teejay.activityfragmentmvp.retrofit.Restapi;
import com.teejay.activityfragmentmvp.ui.main.adapters.PostsAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;
import com.teejay.activityfragmentmvp.util.ApiUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsActivity extends AppCompatActivity implements OnRecycleObjectClickListener<Post> {

Restapi retrofit;
PostsAdapter postsAdapter;
    @BindView(R.id.sample_recycler_view)
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        Intent intent = getIntent();
        String usrId = intent.getStringExtra("key");
        postsAdapter=new PostsAdapter(this);
        ButterKnife.bind(this);
        retrofit=ApiUtils.getRestService();

        postsAdapter.setListener(this);


        mRecyclerView.setAdapter(postsAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getPosts(usrId);

    }
void getPosts(String userId){
    retrofit.getPosts(userId).enqueue(new Callback<List<Post>>() {
        @Override
        public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
            if(response.isSuccessful()) {

                Log.d("MainActivity", response.body().toString());
                postsAdapter.setItems(response.body());

            }else {
                int statusCode  = response.code();
                Log.d("MainActivity", response.message() + response.code());
            }
        }

        @Override
        public void onFailure(Call<List<Post>> call, Throwable t) {

            Log.d("MainActivity", "error loading from API");

        }
    });
}
    @Override
    public void OnItemClick(Post item) {

    }
}
