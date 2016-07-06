package com.example.administrator.pointerapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.pointerapplication.R;

import java.util.List;

/**
 * Created by Administrator on 6/30/2016.
 */
public class MyActivitiesAdpater extends BaseAdapter {

    String[] mData ;
Context context;
   List<String> result;

    public MyActivitiesAdpater(Context c , List<String> data){

        this.context=c;
        this.result = data;

    }

    @Override
    public int getCount() {
        //return mData.length;
        return result.size();
    }

    @Override
    public Object getItem(int position) {
       // return mData[position];
        return result.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.single_listitem_activity, parent, false);

        }

        ((TextView) convertView.findViewById(R.id.textView_activityName)).setText("Posted a question on Udacity Forum");


        return  convertView;
    }

}
