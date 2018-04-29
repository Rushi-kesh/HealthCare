package com.rushikeshgaikwad.healthcaree;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.InputStream;
import java.util.List;

public class SpecialRecords extends AppCompatActivity {
    private String Specializations;

    public String Cityvariable;
    public String Statevariable;
    private ListView listView1;
    private ItemArrayAdapter itemArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_records);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Statevariable = extras.getString("Statevariable");
            Cityvariable = extras.getString("Cityvariable");

            Specializations = extras.getString("Specializations");

        }
        listView1 = (ListView) findViewById(R.id.listV);
        itemArrayAdapter = new ItemArrayAdapter(getApplicationContext(), R.layout.single_list_item);

        InputStream inputStream = getResources().openRawResource(R.raw.dataa);
        Parcelable state = listView1.onSaveInstanceState();


        CSVReader csv = new CSVReader(inputStream);

        List<String[]> scoreList = csv.readSpec(Cityvariable,Specializations);
        for(String [] scoreData : scoreList)
        {
            itemArrayAdapter.add(scoreData);
        }
        listView1.setAdapter(itemArrayAdapter);
        listView1.onRestoreInstanceState(state);






    }
}
