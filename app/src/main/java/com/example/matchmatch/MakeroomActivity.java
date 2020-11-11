package com.example.matchmatch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MakeroomActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addgame);

        //조광식 푸쉬 테스트
        Button submitbutton=(Button)findViewById(R.id.submitaddgame);
        Button cancelbutton =(Button)findViewById(R.id.canceladdgame);




        submitbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("hello cancel");
                EditText location1=(EditText)findViewById(R.id.location);
                location1.setText("This is Cancel");
            }

        });



        cancelbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("hello cancel");
                EditText location1=(EditText)findViewById(R.id.location);
                location1.setText("This is Cancel");
            }

        });







    }

}
