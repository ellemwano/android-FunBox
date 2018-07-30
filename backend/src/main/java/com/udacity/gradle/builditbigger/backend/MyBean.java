package com.udacity.gradle.builditbigger.backend;

import com.mwano.lauren.jokeslibrary.Jokes;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}