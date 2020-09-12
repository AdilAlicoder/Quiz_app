package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ans_show extends AppCompatActivity {
    int count=1;
    TextView ans1,ans2,ans3,ans4,ans5,ans6,ans7,ans8,ans9,ans10;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ans_show);
        imageButton=findViewById(R.id.bkbtn);
        ans1=findViewById(R.id.ans1);
        ans2=findViewById(R.id.ans2);
        ans3=findViewById(R.id.ans3);
        ans4=findViewById(R.id.ans4);
        ans5=findViewById(R.id.ans5);
        ans6=findViewById(R.id.ans6);
        ans7=findViewById(R.id.ans7);
        ans8=findViewById(R.id.ans8);
        ans9=findViewById(R.id.ans9);
        ans10=findViewById(R.id.ans10);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),score_show.class);
                startActivity(intent);
            }
        });
        String book=getIntent().getStringExtra("bok");
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child(book);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (int i=1;i<=10;i++) {
                    String question = snapshot.child(String.valueOf(i)).child("question").getValue(String.class);
                    final String ans = snapshot.child(String.valueOf(i)).child("ans").getValue(String.class);
                    if(i==1) {
                        ans1.setText("1 : "+question + "\n" +"Answer : " +ans);
                    }
                    if(i==2) {
                        ans2.setText("2 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==3) {
                        ans3.setText("3 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==4) {
                        ans4.setText("4 : " +question + "\n" +"Answer : " + ans);
                    }
                    if(i==5) {
                        ans5.setText("5 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==6) {
                        ans6.setText("6 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==7) {
                        ans7.setText("7 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==8) {
                        ans8.setText("8 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==9) {
                        ans9.setText("9 : "+question + "\n" +"Answer : " + ans);
                    }
                    if(i==10) {
                        ans10.setText("10 "+question + "\n" +"Answer : " + ans);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}