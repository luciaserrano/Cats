package com.example.cats;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cats.clases.Breeds;
import com.example.cats.clases.SecondActivity;

import java.util.ArrayList;
import java.util.List;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ListaHolder> {

    private List<Breeds> cat;
    private List<Breeds> copia_lista;
    private final Context context;

    public AdapterMain(Context context){
        this.context=context;
        this.cat = new ArrayList<>();
        this.copia_lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterMain.ListaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ListaHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMain.ListaHolder holder, int position) {
       Breeds gato = cat.get(position);
       final Breeds breedsD = cat.get(position);
       holder.nombre.setText(gato.getName());
        holder.origen.setText(gato.getOrigin());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SecondActivity.class);
                i.putExtra("datos",breedsD); //
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cat.size();
    }

    static  class ListaHolder extends  RecyclerView.ViewHolder{

        private final TextView nombre;
        private final TextView origen;
        public ListaHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.name);
            origen = itemView.findViewById(R.id.origen);
        }

    }
    public void setLista(List<Breeds> lista) {
        cat = lista;
        copia_lista=lista;
        notifyDataSetChanged();
    }

    //Método de filtrado
    public Filter getFilter() {
        //Objeto de tipo Filter
        Filter filter = new Filter() { //Siempre el de {}
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String texto_a_buscar = constraint.toString();

                if(texto_a_buscar.isEmpty()){
                    cat = copia_lista; //Restauramos nuestra copia original
                } else{
                    List<Breeds> listaAuxiliar = new ArrayList<>();//Este es nuestro nuevo listado

//                    for (int i = 0; i < listaCopia.size();i++){
//                        Pokemon pokemon = listaCopia.get(i);
//                    } Es lo mismo que lo de abajo

                    for (Breeds breeds: copia_lista) {

                        String textoBuscarMinus  = texto_a_buscar.toLowerCase();//Ponerlo todo en minuscula

                        String nombre_gato = breeds.getName().toLowerCase();

                        if(nombre_gato.contains(textoBuscarMinus)){ //Contains significa que si está
                            listaAuxiliar.add(breeds);
                        }
                    }
                    cat = listaAuxiliar;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = cat;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) { // Vamos a devolver el resultado
                cat = (List<Breeds>) results.values;
                notifyDataSetChanged();//Para que se actualice
                //Pasarselo al adaptador
            }
        };
        return filter;//Para que devuelva el filtrado creado
    }


}
