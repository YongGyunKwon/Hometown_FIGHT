package com.example.matchmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btn[]=new ImageButton[9];
    ImageButton mypagebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn[0]= findViewById(R.id.imageButton1);
        btn[1]= findViewById(R.id.imageButton2);
        btn[2]= findViewById(R.id.imageButton3);
        btn[3]= findViewById(R.id.imageButton4);
        btn[4]= findViewById(R.id.imageButton5);
        btn[5]= findViewById(R.id.imageButton6);
        btn[6]= findViewById(R.id.imageButton7);
        btn[7]= findViewById(R.id.imageButton8);
        btn[8]= findViewById(R.id.imageButton9);
        mypagebtn = findViewById(R.id.mypageButton);

        btn[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSoccer();
            }
        });
        btn[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFutsal();
            }
        });
        btn[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBasketball();
            }
        });
        btn[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBaseball();
            }
        });
        btn[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBadminton();
            }
        });
        btn[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTabletennis();
            }
        });
        btn[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGolf();
            }
        });
        btn[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTennis();
            }
        });
        btn[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEsports();
            }
        });

        mypagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMypage();
            }
        });
    }

    private void getMypage() {
        Intent intent = new Intent(this, MypageActivity.class);
        startActivity(intent);
    }

    private void getSoccer() {
        Intent intent = new Intent(this, SoccerlistActivity.class);
        startActivity(intent);
    }

    private void getFutsal() {
        Intent intent = new Intent(this, FutsallistActivity.class);
        startActivity(intent);
    }

    private void getBasketball() {
        Intent intent = new Intent(this, BasketballlistActivity.class);
        startActivity(intent);
    }

    private void getBaseball(){
        Intent intent = new Intent(this, BaseballlistActivity.class);
        startActivity(intent);
    }

    private void getBadminton(){
        Intent intent = new Intent(this, BadmintonlistActivity.class);
        startActivity(intent);
    }

    private void getTabletennis(){
        Intent intent = new Intent(this, TabletennislistActivity.class);
        startActivity(intent);
    }

    private void getGolf(){
        Intent intent = new Intent(this, GolflistActivity.class);
        startActivity(intent);
    }

    private void getTennis(){
        Intent intent = new Intent(this, TennislistActivity.class);
        startActivity(intent);
    }

    private void getEsports(){
        Intent intent = new Intent(this, EsportslistActivity.class);
        startActivity(intent);
    }

}




