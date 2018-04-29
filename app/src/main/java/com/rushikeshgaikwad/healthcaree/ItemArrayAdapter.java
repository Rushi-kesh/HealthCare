package com.rushikeshgaikwad.healthcaree;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by gaikw on 1/8/2018.
 */

class ItemArrayAdapter extends ArrayAdapter<String[]> {
    private List<String[]> scoreList = new ArrayList<String[]>();

    static class ItemViewHolder {
        TextView Hname ;
        //TextView Add ;
        TextView Cat ;
        TextView Contact  ;
        TextView TYPE;
        TextView email;
        TextView Web ;
        TextView Spec ;
        TextView Service ;
        TextView pin ;
    }

    public ItemArrayAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(String[] object) {
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int position) {
        return this.scoreList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.hospital_record, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.Hname = row.findViewById(R.id.Hospital);
            viewHolder.Cat = row.findViewById(R.id.Category);
            viewHolder.Contact = row.findViewById(R.id.Contact);
            viewHolder.TYPE = row.findViewById(R.id.Systems_of_Medicine);
            viewHolder.pin = row.findViewById(R.id.pincoder);
            viewHolder.email = row.findViewById(R.id.Email);
            viewHolder.Web = row.findViewById(R.id.Website);
            viewHolder.Spec = row.findViewById(R.id.SpecializationR);
            viewHolder.Service = row.findViewById(R.id.Service_record);


            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder) row.getTag();
        }
        final String[] stat = getItem(position);
        viewHolder.Hname.setText(stat[2]);
        viewHolder.Cat.setText(stat[3]);
        viewHolder.TYPE.setText(stat[4]);
        viewHolder.Contact.setText(stat[5]);
        viewHolder.pin.setText(stat[6]);
        viewHolder.email.setText(stat[7]);
        viewHolder.Web.setText(stat[8]);
        viewHolder.Spec.setText(stat[9]);
        viewHolder.Service.setText(stat[10]);



        return row;

    }
}
