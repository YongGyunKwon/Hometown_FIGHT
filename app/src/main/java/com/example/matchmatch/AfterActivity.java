package com.example.matchmatch;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class AfterActivity extends AppCompatActivity{

    ArrayList<MemberData> datas= new ArrayList<MemberData>();
    ListView listview;
    int peoplecount = 8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        Button chat = findViewById(R.id.Chat);
        listview= findViewById(R.id.listview);
        int count = peoplecount/2;

        for(int a=0; a<count;a++){
            datas.add( new MemberData("EMPTY", "empty ", Color.BLUE));
        }

        for(int a=0; a<count;a++){
            datas.add( new MemberData("EMPTY", "empty ", Color.RED));
        }

        MemberDataAdapter adapter= new MemberDataAdapter( getLayoutInflater() , datas);
        listview.setAdapter(adapter);



        chat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
            }
        });

    }
}
