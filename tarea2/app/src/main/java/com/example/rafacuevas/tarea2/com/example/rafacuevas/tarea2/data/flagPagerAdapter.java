package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rafacuevas.tarea2.R;
import com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.fragments.imageStoreFragment;

public class flagPagerAdapter extends FragmentPagerAdapter {


    public flagPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        int[] arrayStores = new int[]{
                R.drawable.legostore,
                R.drawable.bookstore,
                R.drawable.shoesstore,
                R.drawable.clothesstore,
                R.drawable.winestore,
        };
        Fragment fragment = new imageStoreFragment();
        Bundle args = new Bundle();
        args.putInt(imageStoreFragment.RESOURCE, arrayStores[position]);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
