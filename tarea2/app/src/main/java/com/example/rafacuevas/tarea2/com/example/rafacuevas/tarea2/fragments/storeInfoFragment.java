package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafacuevas.tarea2.R;
import com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.activities.storeInformationActivity;


public class storeInfoFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if (activity instanceof storeInformationActivity){
            String store = ((storeInformationActivity)getActivity()).getStore();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_info, container, false);
    }

}
