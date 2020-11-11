package com.example.matchmatch;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Geocoder geocoder;
    private Button button;
    private Button searchbutton;
    private EditText editText;

    String lattoadd;
    String lngtoadd;
//avc
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        editText = (EditText) findViewById(R.id.editText);
        searchbutton=(Button)findViewById(R.id.search);
        button=(Button)findViewById(R.id.button3);

        Intent intent =getIntent();

        String location = intent.getExtras().getString("location");
        editText.setText(location);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        geocoder=new Geocoder(this);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                MarkerOptions mOptions=new MarkerOptions();

                mOptions.title("마커 좌표");
                Double latitude=latLng.latitude;
                Double longitude=latLng.longitude;

                mOptions.snippet(latitude.toString()+","+longitude.toString());

                mOptions.position(new LatLng(latitude,longitude));

                googleMap.addMarker(mOptions);

            }
        });

        searchbutton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String str=editText.getText().toString();
                List<Address> addressList = null;
                try {
                    // editText에 입력한 텍스트(주소, 지역, 장소 등)을 지오 코딩을 이용해 변환
                    addressList = geocoder.getFromLocationName(
                            str, // 주소
                            10); // 최대 검색 결과 개수
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                //System.out.println(addressList.get(0).toString());
                // 콤마를 기준으로 split
                String []splitStr = addressList.get(0).toString().split(",");
                String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1,splitStr[0].length() - 2); // 주소
                System.out.println(address);

                String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1); // 위도
                String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1); // 경도
                System.out.println(latitude);
                System.out.println(longitude);

                lattoadd=latitude;
                lngtoadd=longitude;

                // 좌표(위도, 경도) 생성
                LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
                // 마커 생성
                MarkerOptions mOptions2 = new MarkerOptions();
                mOptions2.title("search result");
                mOptions2.snippet(address);
                mOptions2.position(point);
                // 마커 추가
                mMap.addMarker(mOptions2);
                // 해당 좌표로 화면 줌
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,15));
            }
        });


//
//        button.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent2 = new Intent(getApplicationContext(),RoomMake.class);
//
//                intent2.putExtra("latitude",lattoadd);
//                intent2.putExtra("longtitude",lngtoadd);
//
//                startActivity(intent2);
//            }
//
//        });

        Intent intenter = new Intent(getApplicationContext(),RoomMake.class);

        String latitude=intenter.getExtras().getString("latitude");
        String longtitude=intenter.getExtras().getString("longtitude");

        Double lat=Double.parseDouble(latitude);
        Double lon=Double.parseDouble(longtitude);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng sydney1 = new LatLng(lat,lon);
        mMap.addMarker(new MarkerOptions().position(sydney1).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney1));
    }
}
