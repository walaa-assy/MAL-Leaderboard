package com.example.administrator.pointerapplication.model;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 7/2/2016.
 */
public class UserActivity {
    String name;
    String owner;
    String url;
    int points;
    String status;

    String dateCreated;
    private HashMap<String, Object> timestampDateCreated;


    private HashMap<String, Object> timestampDateStatusChanged;


    public UserActivity() {
    }



    public UserActivity(String owner, String name, String url, int points, String status, String dateCreated) {
        this.owner = owner;
        this.name = name;
        this.url = url;
        this.points = points;
        this.status = status;
        this.dateCreated=dateCreated;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }




    public HashMap<String, Object> getTimestampDateCreated() {
        return timestampDateCreated;
    }

    public void setTimestampDateCreated(HashMap<String, Object> timestampDateCreated) {
        this.timestampDateCreated = timestampDateCreated;
    }
    public HashMap<String, Object> getTimestampDateStatusChanged() {
        return timestampDateStatusChanged;
    }

    public void setTimestampDateStatusChanged(HashMap<String, Object> timestampDateStatusChanged) {
        this.timestampDateStatusChanged = timestampDateStatusChanged;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("activityName", name);
        result.put("owner", owner);
        result.put("url", url);
        result.put("points", points);
        result.put("status", status);
        result.put("dateCreated", timestampDateCreated);

        return result;
    }

}
