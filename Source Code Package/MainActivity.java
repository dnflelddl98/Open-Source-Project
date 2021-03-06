package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button button;

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;
    private String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button courseButton = (Button) findViewById(R.id.courseButton);
        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final Button messageButton = (Button) findViewById(R.id.messageButton);
        final Button memberButton = (Button) findViewById(R.id.memberButton);
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);
        findViewById(R.id.InfoButton).setOnClickListener(onClickListener);
        findViewById(R.id.logOutButton).setOnClickListener(onClickListener);
        findViewById(R.id.memberButton).setOnClickListener(onClickListener);
        getData();


//        courseButton.setOnClickListener(new View.OnClickListener() {
            //@Override
 //           public void onClick(View view) {
//                notice.setVisibility(View.GONE);
//                courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                messageButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
 //               scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
 //               FragmentManager fragmentManager = getSupportFragmentManager();
  //              FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    //            fragmentTransaction.replace(R.id.fragment, new CourseFragment());
      //          fragmentTransaction.commit();
      //      }
   //     });

     //   scheduleButton.setOnClickListener(new View.OnClickListener() {
       //     @Override
     //       public void onClick(View view) {
       //         notice.setVisibility(View.GONE);
       //         courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
       //         scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        //        messageButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
      //          FragmentManager fragmentManager = getSupportFragmentManager();
      //          FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      //          fragmentTransaction.replace(R.id.fragment, new ScheduleFragment());
      //          fragmentTransaction.commit();
      //      }
     //   });

     //   messageButton.setOnClickListener(new View.OnClickListener() {
     //       @Override
      //      public void onClick(View view) {
      //          notice.setVisibility(View.GONE);
       //         courseButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        //        scheduleButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
       //         messageButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
       //         FragmentManager fragmentManager = getSupportFragmentManager();
       //         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
       //         fragmentTransaction.replace(R.id.fragment, new MessageFragment());
       //         fragmentTransaction.commit();
      //      }
     //   });

        //noticeListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        //{
          //  @Override
            //public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
              //  Intent intent = new Intent(getApplicationContext(), FriendsClicked.class);
               // startActivity(intent);
            //}
        //});

    }

    private void getData() {
        FirebaseFirestore db = FirebaseFirestore.getInstance(); //?????????
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); //?????? ?????? ?????? ???

        startToast("getData() ??????");
        DocumentReference docRef = db.collection("categorize").document(user.getUid());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                category category = documentSnapshot.toObject(category.class);
                type = category.getCategory();
            }
        });
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {               // getData()??? ?????? ????????? ?????? ??????
            switch (v.getId()) {
                case R.id.InfoButton:
                    startIntent();
                    break;

                case R.id.logOutButton:
                    FirebaseAuth.getInstance().signOut();
                    startToast("???????????? ???????????????.");
                    startLogInActivity();
                    break;

                case R.id.memberButton:
                    startToast("?????? ?????? ");
                    startDataShowActivity();
                    break;
            }
        }
    };


    private void startStudentInfoActivity() {
        Intent intent = new Intent(this, StudentInfoActivity.class);
        startActivity(intent);
    }

    private void startSchoolInfoActivity() {
        Intent intent = new Intent(this, SchoolInfoActivity.class);
        startActivity(intent);
    }

    private void startProfessorInfoActivity() {
        Intent intent = new Intent(this, ProfessorInfoActivity.class);
        startActivity(intent);
    }

    private void startDataShowActivity() {
        Intent intent = new Intent(this, dataShowActivity2.class);
        startActivity(intent);
    }

    private void startLogInActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void startIntent() {

        switch (type) {
            case "user":
                startStudentInfoActivity();
                break;

            case "student":
                startToast("?????????????????? ?????????.");
                startStudentInfoActivity();
                break;

            case "professional":
                startProfessorInfoActivity();
                break;

            case "school":
                startToast("?????? ?????? ");
                startSchoolInfoActivity();
                break;
        }
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}