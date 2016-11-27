package com.example.eche.mymascota;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srl_mi_inicador_refresh;
    ListView list_mi_lista;
    RecyclerView.Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        srl_mi_inicador_refresh=(SwipeRefreshLayout)findViewById(R.id.srl_mi_indicador_refresh);
        list_mi_lista=(ListView)findViewById(R.id.list_mi_lista);

        String[] animales=getResources().getStringArray(R.array.animales);
        list_mi_lista.setAdapter(new ArrayAdapter(this,R.layout.simple_list_item,animales));

        srl_mi_inicador_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescandoContenido();
            }
        });
    }

    public void agregarFAB(){
        FloatingActionButton my_fab=(FloatingActionButton)findViewById(R.id.my_fab);
        my_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(),getResources().getString(R.string.app_name),Toast.LENGTH_SHORT).show();
                Snackbar.make(view,getResources().getString(R.string.txt_arrastraRight),Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.txt_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR","Noposguau");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimaryDark))
                        .show();
            }
        });
    }

    public void refrescandoContenido(){
        String[] animales=getResources().getStringArray(R.array.animales);
        list_mi_lista.setAdapter(new ArrayAdapter(this,R.layout.simple_list_item,animales));
        srl_mi_inicador_refresh.setRefreshing(false);
    }
}
