package com.example.matchmatch;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;

import androidx.annotation.NonNull;

//클래스의 이름은 다른 이름이어도 상관없지만 상속만 BaseAdapter를 잘 받으면 됩니다.

public class MemberDataAdapter extends BaseAdapter {



    ArrayList<MemberData> datas;

    LayoutInflater inflater;


    public MemberDataAdapter(LayoutInflater inflater, ArrayList<MemberData> datas) {

// TODO Auto-generated constructor stub



        this.datas= datas;


        this.inflater= inflater;

    }




    @Override

    public int getCount() {

// TODO Auto-generated method stub

        return datas.size(); //datas의 개수를 리턴

    }



    @Override

    public Object getItem(int position) {

// TODO Auto-generated method stub

        return datas.get(position);//datas의 특정 인덱스 위치 객체 리턴.

    }


    @Override

    public long getItemId(int position) {

// TODO Auto-generated method stub

        return position;

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

// TODO Auto-generated method stub


        if( convertView==null){

            convertView= inflater.inflate(R.layout.list_row2, null);

        }


        final TextView text_name= convertView.findViewById(R.id.text_name);
        final TextView text_nation= convertView.findViewById(R.id.info);
        LinearLayout teamline = convertView.findViewById(R.id.teamline);
        final Button partbtn = convertView.findViewById(R.id.part);
        final int participate_flag = 1;


        text_name.setText( datas.get(position).getName() );
        text_nation.setText( datas.get(position).getinfo() );
        teamline.setBackgroundColor(datas.get(position).getcolor());

        partbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                text_name.setText("Doksa08");
                text_nation.setText("신뢰도: 100, 참가횟수: 0");
                partbtn.setText("취소");

            }
        });






        return convertView;

    }


}