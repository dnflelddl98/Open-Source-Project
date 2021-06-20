package com.example.myapplication;

import android.widget.Toast;

public class category {
    private static final String TAG = "category";
    public String type="" ;

    public category(){

    }

    public category(String type){
        this.type = type;
    }

    public String getCategory(){
        return this.type;
    }

    public void setCategory(String type) {
        this.type = type;
    }


}
