package com.rushikeshgaikwad.healthcaree;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Services extends AppCompatActivity implements View.OnClickListener {

        ImageButton Hospital;
        ImageButton Specialization;

        String Cityvariable = null;
        String Statevariable=null;
        String Pincodevariable=null;
        TextView State,City;
        TextView nullstate;
        String Cityy;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
        Statevariable = extras.getString("Statevariable");
        Cityvariable = extras.getString("Cityvariable");

        Cityy = extras.getString("City");

        }
        nullstate=findViewById(R.id.NullState);
        State=findViewById(R.id.Statename);
        City=findViewById(R.id.Cityname);
        State.setText(Statevariable);
        if(Cityy==null)
        {
                City.setText(Cityvariable);
        }

        else
        {
                City.setText(Cityy);
                nullstate.setText("");
                State.setText("");

        }
        Hospital=(ImageButton) findViewById(R.id.Hospital);
        Specialization=(ImageButton) findViewById(R.id.Specialization);
        Hospital.setOnClickListener(this);

        Specialization.setOnClickListener(this);



        }

@Override
public void onClick(View v) {

        switch (v.getId())
        {
        case R.id.Hospital:

        Intent myIntent = new Intent(v.getContext(),main.class);

        myIntent.putExtra("Statevariable",Statevariable);
        myIntent.putExtra( "Cityvariable",Cityvariable);

        myIntent.putExtra( "City",Cityy);

        startActivity(myIntent);
        break;
        case R.id.Specialization:
        Intent myIntent1 = new Intent(v.getContext(), SpecialSearch.class);
        myIntent1.putExtra("Statevariable",Statevariable);
        myIntent1.putExtra( "Cityvariable",Cityvariable);

        myIntent1.putExtra( "City",Cityy);
        startActivity(myIntent1);
        break;

        }

        }
        }
