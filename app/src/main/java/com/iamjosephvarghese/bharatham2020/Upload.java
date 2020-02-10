package com.iamjosephvarghese.bharatham2020;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Upload{

    public String name;
    public String url;
//    public int status;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url) {
        this.name = name;
        this.url= url;
//        this.status=status;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
