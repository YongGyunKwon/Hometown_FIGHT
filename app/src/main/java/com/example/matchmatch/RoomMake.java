package com.example.matchmatch;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.matchmatch.Room.Room;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.w3c.dom.Text;

//import androidx.preference.PreferenceFrageementCompat;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class RoomMake extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();

    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener myDatePicker=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH,month);
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
            updateLabel();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgame);


        Button submitbutton=(Button)findViewById(R.id.submitaddgame);
        Button cancelbutton =(Button)findViewById(R.id.canceladdgame);
        Button addressbutton=(Button)findViewById(R.id.address);

        final EditText roomsubject=(EditText)findViewById(R.id.room_subject);


        final EditText dateset=(EditText)findViewById(R.id.date);
        final EditText timeset=(EditText)findViewById(R.id.time1);
        final TextView latadd=(TextView) findViewById(R.id.lat);
        final TextView lngadd=(TextView)findViewById(R.id.lng);

        final EditText locationset=(EditText)findViewById(R.id.location);

        final Geocoder geocoder=new Geocoder(this,Locale.getDefault());



//        Intent intentmap=getIntent();
//
//        if(!TextUtils.isEmpty(intentmap.getStringExtra("latitude")))
//        {
//            String lat= intentmap.getExtras().getString("latitude");
//            String lng= intentmap.getExtras().getString("longtitude");
//
//
//            latadd.setText(lat);
//            lngadd.setText(lng);
//        }



        dateset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                new DatePickerDialog(RoomMake.this,
                        myDatePicker,
                        myCalendar.get(Calendar.DAY_OF_YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        timeset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(RoomMake.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        String state = "AM";
                        // 선택한 시간이 12를 넘을경우 "PM"으로 변경 및 -12시간하여 출력 (ex : PM 6시 30분)
                        if (selectedHour > 12) {
                            selectedHour -= 12;
                            state = "PM";
                        }
                        // EditText에 출력할 형식 지정
                        timeset.setText(state + " " + selectedHour + "시 " + selectedMinute + "분");
                    }
                }, hour, minute, false); // true의 경우 24시간 형식의 TimePicker 출현
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });


        addressbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                List<Address> list=null;

                String address1=locationset.getText().toString();
                Log.e("Address",address1);
                try{
                    list=geocoder.getFromLocationName(address1,10);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    //Log.e("geocoder","error");

                }

                Address latlng=list.get(0);
                double latt=latlng.getLatitude();
                double lngt=latlng.getLongitude();

                Log.e("lat",Double.toString(latt));
                Log.e("lat",Double.toString(lngt));

                latadd.setText(Double.toString(latt));
                lngadd.setText(Double.toString(lngt));

//                if(list.isEmpty())
//                {
//                    Log.e("Address","No Address");
//                }
//                else
//                {
//                    Address latlng=list.get(0);
//                    double latt=latlng.getLatitude();
//                    double lngt=latlng.getLongitude();
//
//                    Log.e("lat",Double.toString(latt));
//                    Log.e("lat",Double.toString(lngt));
//
//                    latadd.setText(Double.toString(latt));
//                    lngadd.setText(Double.toString(lngt));
//                }



            }
        }
        );





        //submit button
        submitbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),RoomView.class);

                String subject=roomsubject.getText().toString();
                String date=dateset.getText().toString();
                String time=timeset.getText().toString();
                String location=locationset.getText().toString();

                Room room = new Room(subject,date,time,location);

                myRef.child("room").push().setValue(room);

                intent.putExtra("subject",subject);
                intent.putExtra("date",date);
                intent.putExtra("time",time);
                intent.putExtra("location",location);

                startActivity(intent);



            }
        });



        cancelbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);

                String location1=locationset.getText().toString();
                intent.putExtra("location",location1);

                startActivity(intent);
            }

        });


    }

    private void updateLabel()
    {
        String myFormat="yyyy/MM/dd";
        SimpleDateFormat sdf= new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText dateset1=(EditText)findViewById(R.id.date);
        dateset1.setText(sdf.format(myCalendar.getTime()));
    }

}