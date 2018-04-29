package com.rushikeshgaikwad.healthcaree;

import android.app.ProgressDialog;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class main extends AppCompatActivity {
    private ListView listView;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        Bundle extras = getIntent().getExtras();
        String Cityvariable = null;
        String Citty = null;
        if (extras != null) {
            String Statevariable = extras.getString("Statevariable");
            Cityvariable = extras.getString("Cityvariable");

            Citty=extras.getString("City");


        }

                listView = (ListView) findViewById(R.id.LV);
                itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.single_list_item);

                InputStream inputStream = getResources().openRawResource(R.raw.dataa);
                Parcelable state = listView.onSaveInstanceState();


                CSVReader csv = new CSVReader(inputStream);
        final List<String[]> scoreList;

                if(Citty==null)
                {
                   scoreList = csv.read(Cityvariable);
                }
                else if(Citty.equalsIgnoreCase("Pimpri-Chinchwad")||Citty.equalsIgnoreCase("Dattawadi")) {
                    Citty="Pune";
                    scoreList = csv.read(Citty);
                }
                else
                {
                    scoreList = csv.read(Citty);
                }
                for(String [] scoreData : scoreList)
                {
                    itemArrayAdapter.add(scoreData);
                }
                listView.setAdapter(itemArrayAdapter);
                listView.onRestoreInstanceState(state);




            }



}

