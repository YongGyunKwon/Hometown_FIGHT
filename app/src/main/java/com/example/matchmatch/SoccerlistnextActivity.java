package com.example.matchmatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SoccerlistnextActivity extends ListActivity {

    Datainfo datainfo;

    //ImageButton join_btn;

    //FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    //DatabaseReference databaseReference = firebaseDatabase.getReference();

    //private FirebaseAuth firebaseAuth;

    ArrayList<Datainfo> datas = new ArrayList<Datainfo>();
    // ArrayList<Datainfo> db_datas = new ArrayList<Datainfo>();

    Button make_soccer_btn;
    ListView listview;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.soccerlist);
        make_soccer_btn = (Button)findViewById(R.id.make_soccer_room_Button);

        make_soccer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMakeroom();
            }
        });

        //join_btn = findViewById(R.id.go_join_button);

        //dapter = new DatainfoAdapter();

        datas.add(new Datainfo("테스트", "2020-11-18", "20:00", "충북 청주시 개신동 충북대학교", "1/10명"));
        datas.add(new Datainfo("재밌게 축구할 사람~", "2020-11-18", "20:30", "충북 청주시 개신동 충북대학교", "1/4명"));
        datas.add(new Datainfo("축구 고수들만 모이세요", "2020-11-19", "21:00", "충북 청주시 복대동 충북체육관","1/6명"));
        datas.add(new Datainfo("축구 초보들만~", "2020-11-20", "17:30", "충북 청주시 개신동 충북운동장","5/8명"));

        listview = (ListView) findViewById(android.R.id.list);


        DatainfoAdapter adapter = new DatainfoAdapter(getLayoutInflater(), datas);

        //위에 만든 Adapter 객체를 AdapterView의 일종인 ListView에 설정.
        listview.setAdapter(adapter);


    }


    private void getMakeroom() {
        Intent intent = new Intent(this, RoomMake.class);
        startActivity(intent);
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        // MenberData 변수 선언

        Datainfo item = (Datainfo) l.getItemAtPosition(position);

        // 변수에 데이터 넣기
        //String titletext = item.getTitletext();
        //String md = item.getMd();
        //String hm = item.getHm();
        //String state = item.getState();

        // 전달할 Intent에 정보 삽입
        Intent intent = new Intent(this, AfterActivity.class);
        //intent.putExtra("MD",md);
        //intent.putExtra("HM",hm);
        //intent.putExtra("STATE",state);
        //intent.putExtra("TITLETEXT",titletext);

        startActivity(intent);
    }
}