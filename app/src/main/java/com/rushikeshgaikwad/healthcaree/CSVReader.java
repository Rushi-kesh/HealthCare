package com.rushikeshgaikwad.healthcaree;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaikw on 1/8/2018.
 */

class CSVReader {
    InputStream inputStream;


    public CSVReader (InputStream is)
    {
        this.inputStream = is;

    }

    public List<String[]> read(String City) {
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));



        String csvLine = "";

        try {
            reader.readLine();
            while((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");

                String s1=row[1].trim().toString();




               if(s1.equalsIgnoreCase(City))
               {
                   resultList.add(row);

               }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultList;
    }

    public List<String[]> readSpec(String cityvariable, String specializations) {
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String csvLine = "";

        try {
            reader.readLine();
            while((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");


                String s1=row[1].trim().toString();
                String s2=row[9].trim().toString();
                String[] s3=s2.split("-");
                String[] s4=s2.split(" ");
                int flag=0;
                for(String s:s3)
                {
                    if (s.indexOf(specializations)>0)
                    {
                        flag=1;
                    }
                    else if (s.lastIndexOf(specializations)>0)
                    {
                        flag=1;
                    }
                    else if( s.equalsIgnoreCase(specializations))
                    {
                       flag=1;
                    }
                }

                if (s2.equalsIgnoreCase(specializations))
                {
                    flag=1;
                }

                if(s1.equalsIgnoreCase(cityvariable) || flag==1)
                {

                    resultList.add(row);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return resultList;
    }
}
