package com.example.administrator.pointerapplication.model;

/**
 * Created by Administrator on 7/2/2016.
 */
public class Constants {

    public static final String FIREBASE_URL = "https://pointerapplication-47331.firebaseio.com/";

    public static final String FIREBASE_LOCATION_ACTIVE_LIST = "user_activityList" ;
    public static final String FIREBASE_PROPERTY_ACTIVITY_NAME = "name";
    public static final String FIREBASE_PROPERTY_OWNER = "owner";
    public static final String FIREBASE_PROPERTY_URL = "url";
    public static final String FIREBASE_PROPERTY_POINTS = "points";
    public static final String FIREBASE_PROPERTY_STATUS = "status";
    public static final String FIREBASE_PROPERTY_DATE_CREATED = "dateCreated";
    public static final String FIREBASE_PROPERTY_DATE_STATUS_CHANGED= "dateStatusCahnged";

    // public static final String FIREBASE_URL_ACTIVE_LIST = FIREBASE_URL + "/" + FIREBASE_LOCATION_ACTIVE_LIST;
    public static final String FIREBASE_URL_ACTIVE_LIST = "https://pointerapplication-47331.firebaseio.com/current_activity";
}
