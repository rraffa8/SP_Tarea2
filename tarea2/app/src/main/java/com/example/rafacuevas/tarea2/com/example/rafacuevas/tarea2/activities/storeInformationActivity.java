package com.example.rafacuevas.tarea2.com.example.rafacuevas.tarea2.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rafacuevas.tarea2.R;


public class storeInformationActivity extends ActionBarActivity {

    public static final String TITULO = "titulo";
    public static final String DIRECCION = "direccion";
    public static final String TELEFONO = "telefono";
    public static final String WEB = "web";
    public static final String EMAIL = "email";

    private String pais="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_information);

        Intent intent = getIntent();
        String tituloText = intent.getStringExtra(TITULO);
        String direccionText = intent.getStringExtra(DIRECCION);
        String telefonoText = intent.getStringExtra(TELEFONO);
        String webText = intent.getStringExtra(WEB);
        String emailText = intent.getStringExtra(EMAIL);

        if (tituloText != null){
            TextView datosText = (TextView)findViewById(R.id.textTitle);
            datosText.setText(tituloText);
        }

        if (direccionText != null){
            TextView datosText = (TextView)findViewById(R.id.textDir);
            datosText.setText(direccionText);
        }

        if (telefonoText != null){
            TextView datosText = (TextView)findViewById(R.id.textTel);
            datosText.setText(telefonoText);
        }

        if (webText != null){
            TextView datosText = (TextView)findViewById(R.id.textWebSite);
            datosText.setText(webText);
        }

        if (emailText != null){
            TextView datosText = (TextView)findViewById(R.id.textEmail);
            datosText.setText(emailText);
        }

        TextView myPhone = (TextView) findViewById(R.id.textTel);
        Linkify.addLinks(myPhone, Linkify.PHONE_NUMBERS);

        TextView myAddress = (TextView) findViewById(R.id.textDir);
        Linkify.addLinks(myAddress  , Linkify.MAP_ADDRESSES);

        TextView myEmail = (TextView) findViewById(R.id.textEmail);
        Linkify.addLinks(myEmail  , Linkify.EMAIL_ADDRESSES);

        TextView myWeb = (TextView) findViewById(R.id.textWebSite);
        Linkify.addLinks(myWeb  , Linkify.WEB_URLS);


        ImageView imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageResource(R.drawable.ic_launcher);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent newActivity = new Intent(storeInformationActivity.this, imageDetailActivity.class);
                newActivity.putExtra(imageDetailActivity.COMENTARIO, "Este es el comentario para la fotografia");
                storeInformationActivity.this.startActivity(newActivity);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_information, menu);
        return true;
    }

    //@Override
    /*public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_shareS) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public String getStore() {
        Intent intent = getIntent();
        return intent.getStringExtra(TITULO);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_shareS:
                Intent intent = getIntent();
                String detalleTienda = intent.getStringExtra(TITULO) + '\n' + intent.getStringExtra(DIRECCION) + '\n' + intent.getStringExtra(TELEFONO) + '\n' + intent.getStringExtra(WEB) + '\n' + intent.getStringExtra(EMAIL);
                String msg = getString(R.string.share_store, detalleTienda);
                Intent intentSend = new Intent();
                intentSend.setAction(Intent.ACTION_SEND);
                intentSend.putExtra(Intent.EXTRA_TEXT, msg);
                intentSend.setType("text/plain");
                startActivity(Intent.createChooser(intentSend,getString(R.string.action_share)));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
