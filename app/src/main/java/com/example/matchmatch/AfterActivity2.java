package com.example.matchmatch;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class AfterActivity2 extends AppCompatActivity{

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

        datas.add( new MemberData("Trio", "신뢰도: 100, 참가횟수: 1", Color.BLUE,"취소"));
        datas.add( new MemberData("EMPTY", "empty ", Color.BLUE,"참가"));
        datas.add( new MemberData("EMPTY", "empty ", Color.BLUE,"참가"));
        datas.add( new MemberData("EMPTY", "empty ", Color.BLUE,"참가"));

        for(int a=0; a<count;a++){
            datas.add( new MemberData("EMPTY", "empty ", Color.RED,"참가"));
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
