package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class pass_subject extends AppCompatActivity {
    String book;
    int count;
    int i=0;
    int canncel=0;
    String pass;
    TextView textView,textView1,time;
    Button button,button1,button2,button3,button4;
    CountDownTimer countDownTimer;
    ImageButton imageback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_subject);
        final Intent intent=getIntent();
        count=1;
        imageback=findViewById(R.id.mcqsback);
        imageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canncel=1;
                countDownTimer.cancel();
                Intent intent1=new Intent(getApplicationContext(),select_subject.class);
                startActivity(intent1);
            }
        });
        textView=findViewById(R.id.qtxt);
        book=intent.getStringExtra("pass");
        button=findViewById(R.id.next);
        button1=findViewById(R.id.mcq1);
        button2=findViewById(R.id.mcq2);
        button3=findViewById(R.id.mcq3);
        button4=findViewById(R.id.mcq4);
        textView1=findViewById(R.id.plus);
        Intent intent1=getIntent();
        pass=intent1.getStringExtra("show");
        time=findViewById(R.id.timer);
        readdata();
        counttimer();
    }

    private void counttimer() {
        if (countDownTimer != null) {
            if(canncel==1){
                countDownTimer.cancel();
            }
            else {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        } else {
            countDownTimer = new CountDownTimer(25000, 1000) {

                public void onTick(long l) {
                    time.setText(String.valueOf(l/1000));//mtime is a textview
                }

                public void onFinish() {//here mnext is the button from which we can get next question.
                    pick();//this is used to perform clik automatically

                }
            }.start();
        }
    }

    private void readdata() {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child(book);
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String question = snapshot.child(String.valueOf(count)).child("question").getValue(String.class);
                    final String a = snapshot.child(String.valueOf(count)).child("a").getValue(String.class);
                    final String b = snapshot.child(String.valueOf(count)).child("b").getValue(String.class);
                    final String c = snapshot.child(String.valueOf(count)).child("c").getValue(String.class);
                    final String d = snapshot.child(String.valueOf(count)).child("d").getValue(String.class);
                    final String ans = snapshot.child(String.valueOf(count)).child("ans").getValue(String.class);
                    textView.setText(question);
                    button1.setText(a);
                    button2.setText(b);
                    button3.setText(c);
                    button4.setText(d);
                        button1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (ans.equals(a)) {
                                    i = i + 1;
                                }
                                pick();
                            }
                        });
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (ans.equals(b)) {
                                    i = i + 1;
                                }
                                pick();
                            }
                        });
                        button3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (ans.equals(c)) {
                                    i = i + 1;
                                }
                                pick();
                            }
                        });
                        button4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (ans.equals(d)) {
                                    i = i + 1;
                                }
                                pick();
                            }
                        });

                    }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pick();
                }
            });
        }
            private void pick () {
                if (count == 10) {
                    canncel=1;
                    counttimer();
                    Intent intent=new Intent(getApplicationContext(),score_show.class);
                    intent.putExtra("ok",i);
                    intent.putExtra("bok",book);
                    startActivity(intent);

                } else {
                    count = count + 1;
                    textView1.setText(+count + "/10");
                }
                readdata();
                counttimer();
            }

}