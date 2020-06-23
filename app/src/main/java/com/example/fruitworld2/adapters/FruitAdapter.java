package com.example.fruitworld2.adapters;

import android.app.Activity;

import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fruitworld2.R;
import com.example.fruitworld2.models.Fruita;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter <FruitAdapter.Viewholder>{

    //atributs
    private List<Fruita> fruita;
    private int Layout;
    private Activity activity;
    private OnItemClickListener Listener;

    // constructor
    public FruitAdapter(List<Fruita> fruita, int layout, Activity activity, OnItemClickListener Listener) {
        this.fruita = fruita;
        this.Layout = layout;
        this.activity = activity;
        this.Listener = Listener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(Layout, parent,false);
        Viewholder vh= new Viewholder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.bind(fruita.get(position),Listener);

    }

    @Override
    public int getItemCount() {
        return fruita.size();
    }

    public  class  Viewholder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener{

        public TextView textViewNombre;
        public TextView textViewdescripcio;
        public TextView textViewCantitat;
        public ImageView imageViewBacgroud;

        public Viewholder(View itemView){
            super(itemView);
            textViewNombre= itemView.findViewById(R.id.txNom);
            textViewdescripcio= itemView.findViewById(R.id.txDescripcio);
            textViewCantitat = itemView.findViewById(R.id.txCantitat);
            imageViewBacgroud =itemView.findViewById(R.id.imageviewBack);
            // afegim el view al listener per al context menu
            itemView.setOnCreateContextMenuListener(this);

        }
        public  void  bind(final  Fruita fruita, final OnItemClickListener listener){
            this.textViewNombre.setText(fruita.getNombre());
            this.textViewdescripcio.setText(fruita.getDescripcion());
            this.textViewCantitat.setText(fruita.getCantidad()+""); // fem casting de la cantitat  amb +""
            // limitacio dels valors de les fruites
            if(fruita.getCantidad()==Fruita.VALOR_MAX){
                textViewCantitat.setTextColor(ContextCompat.getColor(activity, R.color.colorAlerta)); // posem color roig
                textViewCantitat.setTypeface(null, Typeface.BOLD);
            }else{
                textViewCantitat.setTextColor(ContextCompat.getColor(activity, R.color.colorText)); // posem color nogre
                textViewCantitat.setTypeface(null, Typeface.NORMAL);
            }
           // mostrem imatge amb picasso
            Picasso.get().load(fruita.getImagBack()).fit().into(this.imageViewBacgroud);
            this.imageViewBacgroud.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(fruita,getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            // REcollim la pocicio del clic
            Fruita fruitaSelected = fruita.get(this.getAdapterPosition());
            // establim el titol
            menu.setHeaderTitle(fruitaSelected.getNombre());
            menu.setHeaderIcon(fruitaSelected.getIcono());


            //inflem el menu
            MenuInflater inflater= activity.getMenuInflater();
            inflater.inflate(R.menu.context_menu_item,menu);
            for(int i =0; i<menu.size(); i++){
                menu.getItem(i).setOnMenuItemClickListener(this);
            }


        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.delete_fruit:
                    fruita.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                case R.id.reset_c:
                    fruita.get(getAdapterPosition()).resetCuantitat();
                   notifyItemChanged(getAdapterPosition());
                   return true;

                default:
                    return false;
            }



        }
    }  //12:!2



    public interface  OnItemClickListener{
        void onItemClick(Fruita fruita, int position);
    }
}
