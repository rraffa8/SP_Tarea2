package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rafacuevas.tarea2.R;
import com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.activities.storeInformationActivity;

import java.util.ArrayList;
import java.util.Arrays;


public class listStoreFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView list;
    String tienda="";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] tiendas = new String[]{"tienda de lego", "tienda de libros", "tienda de zapatos", "tienda de ropa", "tienda de vinos"};
        ArrayList<String> Countries = new ArrayList<String>(Arrays.asList(tiendas));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, Countries);

        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
        registerForContextMenu(list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_store, container, false);
        list = (ListView)view.findViewById(R.id.listViewInitial);
        return  view;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        return onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        tienda = ((TextView)info.targetView).getText().toString();
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);


    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        boolean landscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        MenuItem share = menu.getItem(menu.size() - 1);
        share.setVisible(landscape);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shareM) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent newActivity;
        switch (position) {
            case 0:
                newActivity = new Intent(getActivity(), storeInformationActivity.class);
                newActivity.putExtra(storeInformationActivity.TITULO, "Legos");
                newActivity.putExtra(storeInformationActivity.DIRECCION, "436 Mayfield Ave, Stanford, CA");
                newActivity.putExtra(storeInformationActivity.EMAIL, "legos@google.com");
                newActivity.putExtra(storeInformationActivity.TELEFONO, "502 65878657");
                newActivity.putExtra(storeInformationActivity.WEB, "www.legos.com");
                getActivity().startActivity(newActivity);
                break;
            case 1:
                newActivity = new Intent(getActivity(), storeInformationActivity.class);
                newActivity.putExtra(storeInformationActivity.TITULO, "libros");
                newActivity.putExtra(storeInformationActivity.DIRECCION, "1221 22nd Street NW, Washington, DC");
                newActivity.putExtra(storeInformationActivity.EMAIL, "libros@google.com");
                newActivity.putExtra(storeInformationActivity.TELEFONO, "502 56971288");
                newActivity.putExtra(storeInformationActivity.WEB, "www.libros.com");
                getActivity().startActivity(newActivity);
                break;
            case 2:
                newActivity = new Intent(getActivity(), storeInformationActivity.class);
                newActivity.putExtra(storeInformationActivity.TITULO, "zapatos");
                newActivity.putExtra(storeInformationActivity.DIRECCION, "7007 SeaWorld Drive Orlando, FL");
                newActivity.putExtra(storeInformationActivity.EMAIL, "zapatos@google.com");
                newActivity.putExtra(storeInformationActivity.TELEFONO, "502 78972154");
                newActivity.putExtra(storeInformationActivity.WEB, "www.zapatos.com");
                getActivity().startActivity(newActivity);
                break;
            case 3:
                newActivity = new Intent(getActivity(), storeInformationActivity.class);
                newActivity.putExtra(storeInformationActivity.TITULO, "ropa");
                newActivity.putExtra(storeInformationActivity.DIRECCION, "8738 International Drive, Orlando, FL");
                newActivity.putExtra(storeInformationActivity.EMAIL, "ropa@google.com");
                newActivity.putExtra(storeInformationActivity.TELEFONO, "502 18746872");
                newActivity.putExtra(storeInformationActivity.WEB, "www.ropa.com");
                getActivity().startActivity(newActivity);
                break;
            case 4:
                newActivity = new Intent(getActivity(), storeInformationActivity.class);
                newActivity.putExtra(storeInformationActivity.TITULO, "vinos");
                newActivity.putExtra(storeInformationActivity.DIRECCION, "8686 Palm Parkway, Orlando, FL");
                newActivity.putExtra(storeInformationActivity.EMAIL, "vinos@google.com");
                newActivity.putExtra(storeInformationActivity.TELEFONO, "502 39832487");
                newActivity.putExtra(storeInformationActivity.WEB, "www.vinos.com");
                getActivity().startActivity(newActivity);
                break;
            default:
        }
    }
}
