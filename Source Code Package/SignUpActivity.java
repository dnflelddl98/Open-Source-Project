package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity<mRadioCheck> extends AppCompatActivity {
    private RadioButton rg_btn1, rg_btn2, rg_btn3;
    private RadioGroup radioGroup;
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    private int result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.signUpButton).setOnClickListener(onClickListener);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rg_btn1 = (RadioButton) findViewById(R.id.user);
        rg_btn2 = (RadioButton) findViewById(R.id.rg_btn2);
        //rg_btn3 = (RadioButton) findViewById(R.id.rg_btn3);
        rg_btn1.setOnClickListener(onClickListener);
        rg_btn2.setOnClickListener(onClickListener);
       // rg_btn3.setOnClickListener(onClickListener);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.user) {
                    //startToast("?????? ?????????.");
                    startToast("????????? ?????????.");
                    result =1;
                } else if (i == R.id.rg_btn2) {
                    //startToast("?????? ?????????.");
                    startToast("????????? ?????????.");
                    result =2;
                } //else if (i == R.id.rg_btn3) {
                    //startToast("?????? ?????????.");
                   // result =3;
                }
        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.signUpButton:
                    signUp();
                    break;
            }
        }
    };

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }



    private void signUp() {
        String email = ((EditText) findViewById(R.id.emailEditText)).getText().toString();
        String password = ((EditText) findViewById(R.id.passwordEditText)).getText().toString();
        String passwordCheck = ((EditText) findViewById(R.id.passwordCheckEditText)).getText().toString();

        if (email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0) {
            if (password.equals(passwordCheck)) {
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startToast("??????????????? ??????????????????.");
                                    if(result == 1) {
                                        //startStudentInfoActivity();
                                        ClassifyUser();
                                        startMainActivity();
                                    }else if(result ==2){
                                        ClassifyReg();
                                        startProfessorInfoActivity();
                                    }
                                    //else if(result ==3){
                                      //  startSchoolInfoActivity();
                                   // }

                                } else {
                                    if (task.getException() != null) {

                                        startToast("?????? ????????? ??????????????????.");
                                        startToast(task.getException().toString());
                                    }
                                }

                                // ...
                            }
                        });
            } else {
                startToast("??????????????? ???????????? ????????????.");
            }
        } else {
            startToast("????????? ?????? ??????????????? ??????????????????.");
        }
    }

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


    private void startMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    private void startToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void ClassifyUser() {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); //?????? ?????? ?????? ???
            FirebaseFirestore db = FirebaseFirestore.getInstance(); //?????????

            Map<String, Object> categorize= new HashMap<>();            //??????
            categorize.put("category", "user");

            db.collection("categorize").document(user.getUid())
                    .set(categorize)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });
        }

    private void ClassifyReg() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); //?????? ?????? ?????? ???
        FirebaseFirestore db = FirebaseFirestore.getInstance(); //?????????

        Map<String, Object> categorize= new HashMap<>();            //??????
        categorize.put("category", "register");

        db.collection("categorize").document(user.getUid())
                .set(categorize)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });

        startToast("????????? ??????");

    }

}

