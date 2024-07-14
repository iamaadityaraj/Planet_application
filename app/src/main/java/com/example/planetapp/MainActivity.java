package com.example.planetapp;

import android.media.PlaybackParams;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    ArrayList<Planet>planetArrayList;
    private static mycustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        list_view=findViewById(R.id.list_view);
        planetArrayList=new ArrayList<>();


        Planet planet1= new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet2= new Planet("Mercury","0 Moon",R.drawable.mercury);
        Planet planet3= new Planet("Venus","0 Moon ",R.drawable.venus);
        Planet planet4= new Planet("Mars","2 Moon",R.drawable.mars);
        Planet planet5 = new Planet("Jupiter","79 Moon",R.drawable.jupiter);
        Planet planet6= new Planet("Saturn","83 Moon",R.drawable.saturn);
        Planet planet7= new Planet("Uranus","27 Moon",R.drawable.uranus);
        Planet planet8 =new Planet("Neptune","14 Moon",R.drawable.neptune);

        planetArrayList.add(planet1);
        planetArrayList.add(planet2);
        planetArrayList.add(planet3);
        planetArrayList.add(planet4);
        planetArrayList.add(planet5);
        planetArrayList.add(planet6);
        planetArrayList.add(planet7);
        planetArrayList.add(planet8);

        // setup for adapter
        adapter=new mycustomAdapter(planetArrayList,getApplicationContext());
        list_view.setAdapter(adapter);

        // handling a click Event
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,
                        "Planet Name:"+adapter.getItem(i).getPlanetName(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}