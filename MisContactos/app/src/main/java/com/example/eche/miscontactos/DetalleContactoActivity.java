package com.example.eche.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class DetalleContactoActivity extends AppCompatActivity {

    private TextView txt_nombre;
    private TextView txt_telefono;
    private TextView txt_email;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        //Recibimos los parámetros enviados desde MainActivity
        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.param_nombre));
        String telefono = parametros.getString(getResources().getString(R.string.param_telefono));
        String email = parametros.getString(getResources().getString(R.string.param_email));

        txt_nombre = (TextView) findViewById(R.id.txt_nombre);
        txt_telefono = (TextView) findViewById(R.id.txt_telefono);
        txt_email = (TextView) findViewById(R.id.txt_email);

        txt_nombre.setText(nombre);
        txt_telefono.setText(telefono);
        txt_email.setText(email);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //Método para ejecutar una llamada
    public void llamar(View view) {
        String telefono = txt_telefono.getText().toString();
        //Intent implícito
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    //Método para enviar mensaje
    public void enviar_mail(View view) {
        String email = txt_email.getText().toString();
        Log.i("WWW", txt_email.getText().toString());
        //Intent implícito
        Intent email_intent = new Intent(Intent.ACTION_SEND);
        email_intent.setData(Uri.parse("mailto:"));
        email_intent.putExtra(Intent.EXTRA_EMAIL, email);
        email_intent.setType("message/rfc822");
        startActivity(Intent.createChooser(email_intent, "Email"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetalleContactoActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
