package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafacuevas.tarea2.R;
import com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.data.flagPagerAdapter;


public class mapaFragment extends Fragment{
    ViewPager viewPager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        flagPagerAdapter adapter = new flagPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
    }

    /*@Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        flagPagerAdapter adapter = new flagPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mapa, container, false);
        viewPager= (ViewPager)view.findViewById(R.id.pager);
        return view;
    }


}
