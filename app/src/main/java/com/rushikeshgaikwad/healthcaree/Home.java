package com.rushikeshgaikwad.healthcaree;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.*;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    public String Cityvariable;
    public String Statevariable;
    public String City=null;
    private static final int MY_PERMISSION_REQUEST_LOCATION=1;
    Button b2;
    Button emergency;
    ImageButton Ib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        b2=findViewById(R.id.submit);
        Ib=findViewById(R.id.location);
        emergency=findViewById(R.id.Emergency);
        final Spinner Statesspinner = (Spinner) findViewById(R.id.States);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.States, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Statesspinner.setOnItemSelectedListener(this);

        Statesspinner.setAdapter(adapter1);

        Spinner Citiesspinner = (Spinner) findViewById(R.id.Cities);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.Cities, android.R.layout.simple_spinner_item);

        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Citiesspinner.setOnItemSelectedListener(this);

        Citiesspinner.setAdapter(adapter2);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.Pincodes, android.R.layout.simple_spinner_item);

        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Home.this,Manifest.permission.ACCESS_COARSE_LOCATION)){
                        ActivityCompat.requestPermissions(Home.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_LOCATION);

                    }
                    else
                    {
                        ActivityCompat.requestPermissions(Home.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_LOCATION);

                    }
                }else {
                    LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    android.location.Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    try
                    {
                        City= hereLocation(location.getLatitude(),location.getLongitude()).toString();

                        Toast.makeText(Home.this,City,Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                Intent myIntent = new Intent(v.getContext(), Services.class);
                myIntent.putExtra("Statevariable",Statevariable);
                myIntent.putExtra( "Cityvariable",Cityvariable);

                myIntent.putExtra("City",City);
                startActivity(myIntent);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), Services.class);
                myIntent.putExtra("Statevariable",Statevariable);
                myIntent.putExtra( "Cityvariable",Cityvariable);

                myIntent.putExtra("City",City);


                startActivity(myIntent);


            }


        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Home.this,Manifest.permission.ACCESS_COARSE_LOCATION)){
                        ActivityCompat.requestPermissions(Home.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_LOCATION);

                    }
                    else
                    {
                        ActivityCompat.requestPermissions(Home.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_LOCATION);

                    }
                }else {
                    LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    android.location.Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    try
                    {
                        City= hereLocation(location.getLatitude(),location.getLongitude()).toString();

                        Toast.makeText(Home.this,City,Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                Intent myIntent = new Intent(v.getContext(), main.class);
                myIntent.putExtra("Statevariable",Statevariable);
                myIntent.putExtra( "Cityvariable",Cityvariable);

                myIntent.putExtra("City",City);
                startActivity(myIntent);


            }
        });



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST_LOCATION:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(Home.this, Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED){
                        LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        android.location.Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        try
                        {
                            Cityvariable= hereLocation(location.getLatitude(),location.getLongitude());
                            Toast.makeText(this,Cityvariable,Toast.LENGTH_SHORT).show();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }else {
                    Toast.makeText(this,"NO PERMISSION GERANTED!",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;


        if(spinner.getId() == R.id.States)
        {
            Statevariable=spinner.getItemAtPosition(position).toString();

        }
        if(spinner.getId() == R.id.Cities)
        {
            Cityvariable=spinner.getItemAtPosition(position).toString();



        }





    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public String hereLocation(double lat,double lon){
        String City="";
        Geocoder geocoder=new Geocoder(Home.this, Locale.getDefault());
        List<Address> addressList;
        try
        {
            addressList=geocoder.getFromLocation(lat,lon,1);
            if (addressList.size()>0)
            {
                City=addressList.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return City;
    }



}

