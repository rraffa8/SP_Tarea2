package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafacuevas.tarea2.R;
import com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.activities.MainActivity;


public class storeContentFragment extends Fragment
            implements TabListener {

    Fragment[] fragments= new Fragment[]{new listStoreFragment(), new mapaFragment()};

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_store_content, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ActionBar actionbar = ((MainActivity) getActivity()).getSupportActionBar();


        FragmentManager manager = getActivity().getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.mainContent, fragments[0])
                .add(R.id.mainContent, fragments[1])
                .commit();

        if(manager.beginTransaction().isEmpty()) {
            actionbar.addTab(
                    actionbar.newTab().setText(getString(R.string.title_fragment_listado)).setTabListener(this)
            );
            actionbar.addTab(
                    actionbar.newTab().setText(getString(R.string.title_fragment_tienda)).setTabListener(this)
            );
        }

        //fragments[0].setHasOptionsMenu(true);
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Fragment toHide = null;
        Fragment toShow = null;
        switch (tab.getPosition()){
            case 0:
                toHide = fragments[1];
                toShow = fragments[0];
                break;
            case 1:
                toHide = fragments[0];
                toShow = fragments[1];
                break;
        }
        fragmentTransaction.hide(toHide);
        fragmentTransaction.show(toShow);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }
}

