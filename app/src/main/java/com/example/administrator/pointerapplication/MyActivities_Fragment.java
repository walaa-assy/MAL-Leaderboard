package com.example.administrator.pointerapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.pointerapplication.adapters.ActivityListAdapter;
import com.example.administrator.pointerapplication.model.UserActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyActivities_Fragment extends Fragment {



    public MyActivities_Fragment() {
        // Required empty public constructor
    }

    private ActivityListAdapter mActiveListAdapter;
    DatabaseReference activeListsRef;
    @BindView(R.id.listview_my_activitiesList) ListView mListView;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_my_activities, container, false);
        ButterKnife.bind(this,view);
        //List<String> myActivity = new ArrayList<String>(Arrays.asList(activities));
       // MyActivitiesAdpater adapter = new MyActivitiesAdpater(getActivity(),myActivity);

        activeListsRef = FirebaseDatabase.getInstance().getReference("user_activityList");
        mActiveListAdapter = new ActivityListAdapter(getActivity(), UserActivity.class,
                R.layout.single_listitem_activity, activeListsRef);

        /**
         * Set the adapter to the mListView
         */
        mListView.setAdapter(mActiveListAdapter);


        /**
         * Set interactive bits, such as click events and adapters
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActiveListAdapter.cleanup();
    }
}
