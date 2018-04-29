package com.rushikeshgaikwad.healthcaree;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpecialSearch extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private String Specializations;
    public String Pincodevariable;
    public String Cityvariable;
    public String Statevariable;
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_search);
        but=findViewById(R.id.submits);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Statevariable = extras.getString("Statevariable");
            Cityvariable = extras.getString("Cityvariable");
            Pincodevariable = extras.getString("Pincodevariable");


        }
        Spinner Statesspinner = (Spinner) findViewById(R.id.Spec);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.Specialize, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Statesspinner.setOnItemSelectedListener(this);
        Statesspinner.setAdapter(adapter1);
        but.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), SpecialRecords.class);
                myIntent.putExtra("Statevariable",Statevariable);
                myIntent.putExtra( "Cityvariable",Cityvariable);
                myIntent.putExtra( "Pincodevariable",Pincodevariable);
                myIntent.putExtra("Specializations",Specializations);

                startActivity(myIntent);


            }


        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;

        Toast.makeText(this, spinner.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

        if(spinner.getId() == R.id.Spec)
        {
            Specializations=spinner.getItemAtPosition(position).toString();
            Toast.makeText(this, Specializations, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
