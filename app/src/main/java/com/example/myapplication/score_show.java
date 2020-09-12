package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class score_show extends AppCompatActivity {
    TextView textView;
    Button ans,finish;
    String book;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_show);
        textView=findViewById(R.id.score);
        ans=findViewById(R.id.ans);
        final Intent intent=getIntent();
        imageButton=findViewById(R.id.mcqz);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),pass_subject.class);
                startActivity(intent1);
            }
        });
        book=intent.getStringExtra("bok");
        finish=findViewById(R.id.finish);
        int number = getIntent().getExtras().getInt("ok");
        textView.setText("SCORE \n"+number+"/10");
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ans_show.class);
                intent.putExtra("bok",book);
                startActivity(intent);
            }
        });
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),select_subject.class);
                startActivity(intent1);
            }
        });
    }
}