package com.example.planetapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class mycustomAdapter extends ArrayAdapter<Planet> {

    // for custom layout we created mycustomadapter class
    // for custom model class or custom object we use arrayadapter

    // we use arrayList instead of array because there arrayList is feature of Dyanmically Increase and decrease Size
    // where as array we have to intialized array size at the time of creation
    private ArrayList<Planet>planetArrayList;

    Context context;


    // Constructor
    public mycustomAdapter( ArrayList<Planet> planetArrayList, Context context1) {

        // R.layout is infalte the arrayList of every item

        super(context1, R.layout.item_list_layout,planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context1;
    }

    // viewHolder Class
    private static class myviewHolder{
        ImageView planetImg;
        TextView planetName;
        TextView MoonCount;
    }

    @NonNull
    @Override
    // getview method simply override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        //1.   get the planets object for the current position .
        Planet planets=getItem(position);
    //2. layout Inflate :- Inflate means converting layout xml into view object Memory
        myviewHolder holder;
        final View Result;
        // if convertview == null ,, LayoutInflatter of infalte custom layout
        if(convertView==null){
             holder= new myviewHolder();
             convertView= LayoutInflater.from(context).inflate(
                     R.layout.item_list_layout,
                     parent,
                     false

             );

             // finding views :-
             holder.planetName=(TextView) convertView.findViewById(R.id.planetName);
             holder.planetImg=(ImageView) convertView.findViewById(R.id.planetImg);
             holder.MoonCount=(TextView) convertView.findViewById(R.id.MoonCount);
             Result =convertView;

             convertView.setTag(holder);
        }
        else {
            holder=(myviewHolder) convertView.getTag();
            Result = convertView;

        }
        // get the data from the model class (planet)
        holder.planetName.setText(planets.getPlanetName());
        holder.MoonCount.setText(planets.getMoonCount());
        holder.planetImg.setImageResource(planets.getPlanetImage());

        return Result;
    }
}