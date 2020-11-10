package com.example.matchmatch;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //kwon
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_addgame);


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




