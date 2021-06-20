package com.example.myapplication;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class dataShowActivity extends AppCompatActivity {
    private static final String TAG = "dataShowActivity";
   // String name, number, major;

    private TextView textView1 = (TextView)findViewById(R.id.noticeText);
  //  private ArrayList<MemberInfo> memberList;
   // private MemberListAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_show2);

        final Button dataButton = (Button) findViewById(R.id.databutton);
      //  final LinearLayout member = (LinearLayout) findViewById(R.id.member);
        //TextView textView1 = (TextView) findViewById(R.id.textView) ;
        //memberList = new ArrayList<MemberInfo>();

        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-12-12"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-11-10"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-09-07"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-08-29"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-07-26"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-06-25"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-05-13"));
        //memberList.add(new MemberInfo("공지사항", "학사팀", "2020-04-23"));
        //adapter2 = new MemberListAdapter(getApplicationContext(), memberList) {
          //  @Override
            //public View getView(int i, View view, ViewGroup viewGroup) {
              //  return null;
            //}
        //};
        //memberListView.setAdapter(adapter2);

 //       dataButton.setOnClickListener(new View.OnClickListener() {
 //           @Override
 //           public void onClick(View view) {
 //              getData();
 //           }
  //      });
  //  }


   // private void getData() {
    //    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); //유저 구분 고유 키
     //   FirebaseFirestore db = FirebaseFirestore.getInstance(); //초기화
        //DocumentReference docRef = db.collection("school").document("hello");
      //  DocumentReference docRef = db.collection("categorize").document(user.getUid());
      //  docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
       //     @Override
        //    public void onSuccess(DocumentSnapshot documentSnapshot) {
         //       category category = documentSnapshot.toObject(category.class);
          //      String type = category.getCategory();
           //     textView1.setText(type);
           // }
       // });

            //  @Override
            // public void onSuccess(DocumentSnapshot documentSnapshot) {
            //    MemberInfo member = documentSnapshot.toObject(MemberInfo.class);
            //   major = member.getMajor();
            //  name = member.getName();
            // number = member.getNumber();
            // }
            // });
    }
    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}