package com.example.matchmatch;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;


public class RoomView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_roomview);


        TextView tx1=(TextView)findViewById(R.id.textView5);
        TextView tx2=(TextView)findViewById(R.id.textView6);
        TextView tx3=(TextView)findViewById(R.id.textView7);
        TextView tx4=(TextView)findViewById(R.id.textView8);


        Intent intent=getIntent();

        String text1=intent.getExtras().getString("subject");
        String text2=intent.getExtras().getString("date");
        String text3=intent.getExtras().getString("time");
        String text4=intent.getExtras().getString("location");


        tx1.setText(text1);
        tx2.setText(text2);
        tx3.setText(text3);
        tx4.setText(text4);




    }

}
