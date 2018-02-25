package com.teejay.activityfragmentmvp.ui.main.adapters;

/**
 * Created by tjaved on 1/28/18.
 */
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teejay.activityfragmentmvp.R;
import com.teejay.activityfragmentmvp.data.model.Users;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.BaseViewHolder;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.GenericRecycleAdapter;
import com.teejay.activityfragmentmvp.ui.main.adapters.base.OnRecycleObjectClickListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleAdapter extends GenericRecycleAdapter<Users,
        OnRecycleObjectClickListener<Users>,SampleAdapter.SampleViewHolder> {

    @Inject
    public SampleAdapter(Context context) {
        super(context);
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sample, parent, false);
        return new SampleViewHolder(itemView);
    }


    class SampleViewHolder extends BaseViewHolder<Users, OnRecycleObjectClickListener<Users>> {
        @BindView(R.id.usrName)
        TextView tvusrName;
        @BindView(R.id.usrAddress)
        TextView tvAddress;
        @BindView(R.id.usrGeo)
        TextView tvGeo;


        public SampleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
        @Override
        public void onBind(Users item, @Nullable final OnRecycleObjectClickListener<Users> listener) {
            final Users user = item;
            tvusrName.setText(item.getUsername());
            tvAddress.setText(item.getAddress().getStreet()+"\n"+item.getAddress().getCity()+" "+item.getAddress().getZipcode());
            tvGeo.setText(item.getAddress().getGeo().getLat()+" "+item.getAddress().getGeo().getLng());
            if (listener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        listener.OnItemClick(user);
                    }
                });
            }

        }
    }
}
