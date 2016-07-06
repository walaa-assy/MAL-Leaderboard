package com.example.administrator.pointerapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pointerapplication.model.UserActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AddActivity_Fragment extends Fragment {

    String activityName;
    String activityURL;
    String owner = "Anonymous";
    String status = "pending";
    String formattedDate;
    int points ;

    @BindView(R.id.spinner)
    Spinner spnr;
    @BindView(R.id.activityURL)
    EditText urlText;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.textview_username) TextView textView_username;
   // @BindView(R.id.textview_chosenActivity) TextView textView_chosenActivity;

    String[] formerActivities = {
            "Post a question on Udacity forum - 1Pt",
            "Post an answer to Udacity forum - 3Pts",
            "Help a Team mate on Slack - 2Pts",
            "Deliver assignments - 4Pts",
            "Finish lesson on time - 5Pts",
            "Reserve 1:1 appointment with Udacity coaches - 2Pts",
            "Attend Udacity webcast - 2Pts",
            "Deliver Movies App before April 15th - 25Pts",
            "Deliver Movies App - 10Pts",
            "Finish exercise in the Study Group - 10Pts",
            "Finish Lesson 5 before due date - 15Pts"
    };

    String[] activities = {
            "Post a question on Udacity forum ",
            "Post an answer to Udacity forum ",
            "Help a Team mate on Slack ",
            "Deliver assignments ",
            "Finish lesson on time ",
            "Reserve 1:1 appointment with Udacity coaches ",
            "Attend Udacity webcast ",
            "Deliver Movies App before April 15th ",
            "Deliver Movies App ",
            "Finish exercise in the Study Group ",
            "Finish Lesson 5 before due date "
    };


    public AddActivity_Fragment() {
        // Required empty public constructor
    }

    public int switchPoints(String activityName){
        switch (activityName)
        {
            case "Post a question on Udacity forum - 1Pt":
                activityName = "Post a question on Udacity forum";
                points = 1;
                break;
            case "Post an answer to Udacity forum - 3Pts":
                activityName = "Post an answer to Udacity forum ";
                points = 3;
                break;
            case "Help a Team mate on Slack - 2Pts":
                activityName = "Help a Team mate on Slack ";
                points = 2;
                break;
            case "Deliver assignments - 4Pts":
                activityName= "Deliver assignments ";
                points = 4;
                break;
            case "Finish lesson on time - 5Pts":
                activityName = "Finish lesson on time - 5Pts";
                points = 5;
                break;
            case "Reserve 1:1 appointment with Udacity coaches - 2Pts":
                activityName = "Reserve 1:1 appointment with Udacity coaches ";
                points = 2;
                break;
            case "Attend Udacity webcast - 2Pts":
                activityName = "Attend Udacity webcast ";
                points = 2;
                break;
            case "Deliver Movies App before April 15th - 25Pts":
                activityName = "Deliver Movies App before April 15th ";
                points = 25;
                break;
            case "Deliver Movies App - 10Pts":
                activityName = "Deliver Movies App ";
                points = 10;
                break;
            case "Finish exercise in the Study Group - 10Pts":
                activityName = "Finish exercise in the Study Group ";
                points = 10;
                break;
            case "Finish Lesson 5 before due date - 15Pts":
                activityName = "Finish Lesson 5 before due date ";
                points = 15;
                break;
            default:
                break;
        }
        return points;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_activity, container, false);
        ButterKnife.bind(this, view);
        // Inflate the layout for this fragment

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, activities);
        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spnr.getSelectedItemPosition();
                        activityName = activities[position];
                       // Toast.makeText(getActivity(), "You have selected " + activities[position], Toast.LENGTH_LONG).show();
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
               // SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); "dd.MM.yyyy"
                 formattedDate = df.format(c.getTime());
                points = switchPoints(activityName);
                activityURL = urlText.getText().toString().trim();
                if (activityURL.matches("")) {
                    Toast.makeText(getActivity(), "You did not enter a URL", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    //addActivityToFirebase(activityName, activityURL);
                    addAllActivities();
                    Toast.makeText(getActivity(), " Done! " , Toast.LENGTH_SHORT).show();
                }
            }

        });
        return view;
    }

public void addActivityToFirebase(String aType , String aUrl){

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    UserActivity current = new UserActivity(owner,aType ,aUrl, 4,status , formattedDate);
    DatabaseReference myRef = database.getReference("current_activity");
    myRef.setValue(current);

    myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            UserActivity value = dataSnapshot.getValue(UserActivity.class);
            //Log.d(TAG, "Value is: " + value);
            textView_username.setText("Hello, "+ value.getOwner() + "!");
           // textView_chosenActivity.setText(value.getName());

        }

        @Override
        public void onCancelled(DatabaseError error) {
            // Failed to read value
            Log.w("TAG", "Failed to read value.", error.toException());
        }
    });

}

    public void addAllActivities(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user_activityList").push();
        String activityKey = myRef.getKey();
//        HashMap<String, Object> timestampCreated = new HashMap<>();
//        timestampCreated.put("timestampDatecreated", ServerValue.TIMESTAMP);
        UserActivity current = new UserActivity(owner,activityName,activityURL,points,status,formattedDate);
        myRef.setValue(current);
       // HashMap<String, Object> timestampCreated = new HashMap<>();
        // timestampCreated.put("timestamp_datecreated", ServerValue.TIMESTAMP);
    }


}
