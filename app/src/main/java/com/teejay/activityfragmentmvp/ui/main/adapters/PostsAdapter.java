package com.teejay.activityfragmentmvp.ui.main.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Post;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.BaseViewHolder;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.GenericRecycleAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tjaved on 2/25/18.
 */

public class PostsAdapter extends GenericRecycleAdapter<Post,
        OnRecycleObjectClickListener<Post>,PostsAdapter.PostsViewHolder> {


    public PostsAdapter(Context context) {
        super(context);
    }

    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_posts, parent, false);
        return new PostsAdapter.PostsViewHolder(itemView);
    }




    class PostsViewHolder extends BaseViewHolder<Post, OnRecycleObjectClickListener<Post>> {
        @BindView(R.id.title)
        TextView postTitle;
        @BindView(R.id.body)
        TextView postBody;



        public PostsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @Override
        public void onBind(Post item, @Nullable final OnRecycleObjectClickListener<Post> listener) {

            final Post post= item;
            postTitle.setText(post.getTitle());
            postBody.setText(post.getBody());


        }
    }
}