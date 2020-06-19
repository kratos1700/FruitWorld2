package com.example.fruitworld2.activitis;
//exercici 3
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fruitworld2.R;
import com.example.fruitworld2.adapters.FruitAdapter;
import com.example.fruitworld2.models.Fruita;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    //private FruitAdapter adapter;

    private List<Fruita> fruites;
    private  int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruites = getAllFruites(); // creem la llista de fruites
        recyclerView = new LinearLayoutManager(this);

    }



    private List<Fruita> getAllFruites(){
        return new ArrayList<Fruita>(){
            {
                add(new Fruita("Maduixa", "Descripcio Maduixes", R.drawable.strawberry_bg, R.mipmap.maduixa_ic, 0));
                add(new Fruita("Taronja", "Descripcio Taronja", R.drawable.orange_bg, R.mipmap.orange_ic, 0));
                add(new Fruita("Poma", "Descripcio Poma", R.drawable.apple_bg, R.mipmap.apple_ic, 0));
                add(new Fruita("Platan", "DEscripcio Platan", R.drawable.banana_bg, R.mipmap.banana_ic, 0));
                add(new Fruita("Cirera", "Descripcio Cirera", R.drawable.cherry_bg, R.mipmap.cherry_ic, 0));
                add(new Fruita("Pera", "Descripcio Pera", R.drawable.pear_bg, R.mipmap.pear_ic, 0));
                add(new Fruita("Presec", "Descripcio Presec", R.drawable.plum_bg, R.mipmap.plum_ic, 0));
                add(new Fruita("Mora", "DEscripcio Mora", R.drawable.raspberry_bg, R.mipmap.raim_ic, 0));
            }
        };
    }
}
