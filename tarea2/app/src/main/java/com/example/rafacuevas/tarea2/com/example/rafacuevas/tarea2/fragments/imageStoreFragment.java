package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rafacuevas.tarea2.R;

public class imageStoreFragment extends Fragment {
    public final static String RESOURCE = "resource";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image_store, container, false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageStoreView);
        Bundle args = getArguments();

        imageView.setImageResource(args.getInt(RESOURCE));

        return view;
    }
}
