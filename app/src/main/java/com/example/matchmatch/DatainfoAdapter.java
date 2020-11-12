package com.example.matchmatch;

import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;

import org.w3c.dom.Text;

import java.util.ArrayList;


//extends BaseAdapter;
public class DatainfoAdapter extends BaseAdapter {
    ArrayList<Datainfo> datas;

    LayoutInflater inflater; //XML에 있는걸 화면에 가져오는거


    public DatainfoAdapter(LayoutInflater inflater, ArrayList<Datainfo> datas) {
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
            convertView= inflater.inflate(R.layout.list_row, null);
        }


        TextView text_title_text= (TextView)convertView.findViewById(R.id.text_title);
        TextView text_md_text= (TextView)convertView.findViewById(R.id.text_md);
        TextView text_hm_text= (TextView)convertView.findViewById(R.id.text_hm);
        TextView text_state_text= (TextView)convertView.findViewById(R.id.text_state);
        TextView text_people= (TextView)convertView.findViewById(R.id.text_people);

        text_title_text.setText( datas.get(position).getTitletext() );
        text_md_text.setText( "날짜 : "+datas.get(position).getMd() );
        text_hm_text.setText( "시간 : " + datas.get(position).getHm() );
        text_state_text.setText( "장소 : " + datas.get(position).getState() );
        text_people.setText("인원: " + datas.get(position).getPeople());

        return convertView;
    }
}
