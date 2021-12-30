package com.example.cats.clases;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cats.Fragment.Fragment1;
import com.example.cats.Fragment.Fragment2;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private Breeds breeds;
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Breeds breeds) { //Le indico los datos
        super(fragmentManager, lifecycle);
        this.breeds=breeds;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return new Fragment1(breeds);
        } else if(position==1){
            return new Fragment2(breeds);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
