package com.example.cats.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cats.R;
import com.example.cats.clases.Breeds;

public class Fragment1 extends Fragment {

    Breeds breeds;
    private TextView weight,temperament,origin,life_span,descripcion;

    public Fragment1(Breeds breeds) {
        this.breeds=breeds;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frame_information,container,false);
        weight = v.findViewById(R.id.t_weight);
        temperament = v.findViewById(R.id.t_temperament);
        origin = v.findViewById(R.id.t_origin);
        life_span = v.findViewById(R.id.t_life);
        descripcion = v.findViewById(R.id.t_description);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        weight.setText(String.valueOf(breeds.getWeight().getImperial()));
        temperament.setText(breeds.getTemperament());
        origin.setText(breeds.getOrigin());
        life_span.setText(breeds.getLifeSpan());
        descripcion.setText(breeds.getDescription());
    }
}
