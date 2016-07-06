package com.example.administrator.pointerapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.pointerapplication.AddActivity_Fragment;
import com.example.administrator.pointerapplication.Leaderboard_Fragment;
import com.example.administrator.pointerapplication.MyActivities_Fragment;

/**
 * Created by Administrator on 6/28/2016.
 */
public class ActivityPagerAdapater extends FragmentPagerAdapter {
    public ActivityPagerAdapater(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new AddActivity_Fragment();
            case 1:
                return new MyActivities_Fragment();
            case 2:
                return new Leaderboard_Fragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Add Activity";

            case 1:
                return "My Activities";
            case 2:
                return "Leaderboard";
        }
        return null;
    }
}
