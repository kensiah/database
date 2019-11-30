package com.example.phonenumberrecordapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactsAdapter extends ArrayAdapter {
    private ArrayList<Contact> data;
    private Context context;
    private View v;

    public ContactsAdapter(Context context, ArrayList<Contact> data){
        super(context, R.layout.activity_save);
        this.data = data;
        this.context = context;
    }

    @Nullable
    @Override

    public Object getItem(int pos){
        return super.getItem(pos);
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        super.getView(position, convertView, parent);
        View v ;
        Viewholder holder;
        if(convertView == null){
            holder = new Viewholder();
            v = LayoutInflater.from(context).inflate(R.layout.activity_save,null);

            holder.tvName = v.findViewById(R.id.tv_name);
            holder.tvPhone = v.findViewById(R.id.tv_phone);

            v.setTag(holder);

        }else{
            holder = (Viewholder) convertView.getTag();
            v = convertView;
        }

        Contact model =  (Contact)getItem(position);

        holder.tvName.setText(model.getName());
        holder.tvPhone.setText(model.getPhoneNumber());

        return v;
    }

    class Viewholder{
        TextView tvName,tvPhone;
    }
}
