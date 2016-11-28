package com.example.eche.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contacto> contactos;
    private RecyclerView lista_contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mi_actionbar=(Toolbar)findViewById(R.id.mi_actionbar);
        setSupportActionBar(mi_actionbar);

        lista_contactos=(RecyclerView)findViewById(R.id.rv_contactos);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista_contactos.setLayoutManager(llm);

        /*
        //Descomentar para comportamiento de GridLayout y en su lugar comentar el LinearLayout
        GridLayoutManager glm=new GridLayoutManager(this,2);
        lista_contactos.setLayoutManager(glm);
        */

        inicializarListaContactos();
        inicializarAdaptador();


        /*
        //Ocultando ListView, para probar RecyclerView, para probar ListView, comentar el código de ReciclerView dentro del oncreate y en su lugar descomentar este
        ArrayList<String> nombres_contacto=new ArrayList<>();
        for (Contacto contacto:contactos) {
            nombres_contacto.add(contacto.getNombre());
        }

        ListView lst_contactos=(ListView)findViewById(R.id.lst_contactos);
        lst_contactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombres_contacto));

        lst_contactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //i:posicion del elemento (0,1,... según cómo esté en la lista de contactos)
                //La llave pasada en putExtra será un valor de los recursos en string.xml,podemos ponerle algo aleatoriio, pero para llamarlos debemos usar la misma llave
                //Intent Explícito:
                Intent intent=new Intent(MainActivity.this,DetalleContactoActivity.class);
                intent.putExtra(getResources().getString(R.string.param_nombre),contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.param_telefono),contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.param_email),contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });
        */
    }

    public void inicializarAdaptador(){
        ContactoAdapter adapter=new ContactoAdapter(contactos,this);
        lista_contactos.setAdapter(adapter);
    }

    public void inicializarListaContactos(){
        contactos=new ArrayList<Contacto>();
        contactos.add(new Contacto("Alexis Eche","999999999","alexis@example.com",R.mipmap.ic_user_blue));
        contactos.add(new Contacto("Pepe Grillo","777777777","pepe@example.com",R.mipmap.ic_user_yellow));
        contactos.add(new Contacto("Elva Zurita","888888888","elva@example.com",R.mipmap.ic_user_red));
        contactos.add(new Contacto("Javier Eche","989898989","javier@example.com",R.mipmap.ic_user_green));
        contactos.add(new Contacto("Alambrito Delgado","878787878","alambrito@example.com",R.mipmap.ic_user_yellow));

    }
}
