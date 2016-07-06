package com.example.administrator.pointerapplication.adapters;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.pointerapplication.R;
import com.example.administrator.pointerapplication.model.UserActivity;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 7/3/2016.
 */
public class ActivityListAdapter extends FirebaseListAdapter<UserActivity> {

    @BindView(R.id.textView_activityName) TextView name;
    @BindView(R.id.textview_points) TextView points;
    @BindView(R.id.textView_dateCreated) TextView date;
    @BindView(R.id.textview_status)TextView status;

    public ActivityListAdapter(Activity activity, Class<UserActivity> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
    }

    public ActivityListAdapter(Activity activity, Class<UserActivity> modelClass, int modelLayout, DatabaseReference ref) {
        super(activity, modelClass, modelLayout, ref);
    }



    @Override
    protected void populateView(View view, UserActivity model, int position) {
        ButterKnife.bind(this, view);
//        TextView name = (TextView) view.findViewById(R.id.textView_activityName);
//        TextView points = (TextView) view.findViewById(R.id.textview_points);
//        TextView date = (TextView) view.findViewById(R.id.textView_dateCreated);
//        TextView status = (TextView) view.findViewById(R.id.textview_status);

        name.setText(model.getName());
        points.setText(String.valueOf(model.getPoints()) + " Pts");
        date.setText(model.getDateCreated());
        status.setText(model.getStatus());

//        name.setText(String.valueOf(model.getName()));
//        points.setText(String.valueOf(model.getPoints()));
//        date.setText(String.valueOf(model.getDateCreated()));
//        status.setText(String.valueOf(model.getStatus()));
    }


}
