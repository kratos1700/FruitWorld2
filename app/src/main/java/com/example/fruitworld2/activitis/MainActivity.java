package com.example.fruitworld2.activitis;
//exercici 3

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitworld2.R;
import com.example.fruitworld2.adapters.FruitAdapter;
import com.example.fruitworld2.models.Fruita;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FruitAdapter adapter;

    private List<Fruita> fruites;
    private  int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruites = getAllFruites(); // creem la llista de fruites

        recyclerView= findViewById(R.id.recicler); // asignem la vista del recicler view
        layoutManager= new LinearLayoutManager(this);
        //adaptador
        adapter = new FruitAdapter(fruites,R.layout.recicleritem, this, new FruitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruita fruita, int position) {
                fruita.addCuantitat(1);
                adapter.notifyItemChanged(position);

            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:
                int posicio= fruites.size();
                fruites.add(posicio, new Fruita("Plum" +(++contador), "Fruita afegida per l'usuari",R.drawable.plum_bg, R.mipmap.plum_ic,0 ));
                adapter.notifyItemInserted(posicio);
                layoutManager.scrollToPosition(posicio);
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
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
