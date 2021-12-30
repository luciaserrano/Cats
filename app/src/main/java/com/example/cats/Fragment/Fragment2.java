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

public class Fragment2 extends Fragment {
    Breeds breeds;
    private TextView adaptability,affection,child,dog,energy,health,inteligence,shedding,social;

    public Fragment2(Breeds breeds) {
        this.breeds=breeds;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frame_stats,container,false);
        adaptability = v.findViewById(R.id.t_adaptability);
        affection = v.findViewById(R.id.t_affection);
        child = v.findViewById(R.id.t_child);
        dog = v.findViewById(R.id.t_dog);
        energy = v.findViewById(R.id.t_energy);
        health = v.findViewById(R.id.t_healt);
        inteligence = v.findViewById(R.id.t_inteligence);
        shedding = v.findViewById(R.id.t_shedding);
        social = v.findViewById(R.id.t_social);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adaptability.setText(String.valueOf(breeds.getAdaptability()));
        affection.setText(String.valueOf(breeds.getAffectionLevel()));
        child.setText(String.valueOf(breeds.getChildFriendly()));
        dog.setText(String.valueOf(breeds.getDogFriendly()));
        energy.setText(String.valueOf(breeds.getEnergyLevel()));
        health.setText(String.valueOf(breeds.getHealthIssues()));
        inteligence.setText(String.valueOf(breeds.getIntelligence()));
        shedding.setText(String.valueOf(breeds.getSheddingLevel()));
        social.setText(String.valueOf(breeds.getSocialNeeds()));
    }
}
