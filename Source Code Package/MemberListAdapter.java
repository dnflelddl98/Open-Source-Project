package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public abstract class MemberListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MemberInfo> memberList;

    public MemberListAdapter(Context context, ArrayList<MemberInfo> memberList) {
        this.context = context;
        this.memberList = memberList;
    }

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Object getItem(int i) {
        return memberList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //@Override
   // public View getView(int i, View convertView, ViewGroup parent) {
      //  View v = View.inflate(context, R.layout.activity_notice, null);
       // TextView major = (TextView)v.findViewById(R.id.);
        //TextView name = (TextView)v.findViewById(R.id.nameText);
        //TextView number = (TextView)v.findViewById(R.id.dateText);

        //noticeText.setText(memberList.get(i).getMajor());
        //nameText.setText(memberList.get(i).get());
        //dateText.setText(memberList.get(i).getDate());

        //v.setTag(memberList.get(i).getNotice());
      //  return v;
    //}

}
