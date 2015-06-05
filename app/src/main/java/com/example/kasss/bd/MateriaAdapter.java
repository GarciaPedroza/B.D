package com.example.kasss.bd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USUARIO on 28/05/2015.
 */
public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.materiaViewHolder>  {

        private List<ModeloMateria> items;

        public static class materiaViewHolder extends RecyclerView.ViewHolder{


            public TextView id_materia;
            public TextView nombre;
            public TextView creditos;
            public TextView semestre;

            public materiaViewHolder(View v){
                super(v);
                id_materia = (TextView) v.findViewById(R.id.id_m);
                nombre= (TextView) v.findViewById(R.id.nomb);
                creditos = (TextView) v.findViewById(R.id.cre);
                semestre= (TextView) v.findViewById(R.id.seme);
            }
        }

        public MateriaAdapter(List<ModeloMateria> items){
            this.items= items;
        }

        @Override
        public materiaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.activity_materia_car, viewGroup, false);
            return new materiaViewHolder(v);
        }

        @Override
        public void onBindViewHolder(materiaViewHolder materiaViewHolder, int i) {
            materiaViewHolder.id_materia.setText("id de materia: "+ String.valueOf(items.get(i).getId_materia()));//solo a este por que es numerico, los demas ya son Strings
            materiaViewHolder.nombre.setText("nombre: "+ String.valueOf(items.get(i).getNombre()));
            materiaViewHolder.creditos.setText("creditos: " + String.valueOf(items.get(i).getCreditos()));
            materiaViewHolder.semestre.setText("semestre: " + String.valueOf(items.get(i).getSemestre()));


        }

        @Override
        public int getItemCount() {

            return items.size();
        }
    }

