package com.example.eche.miscontactos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Alexis on 28/11/2016.
 */
public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{
    ArrayList<Contacto> contactos;
    Context activity;
    public ContactoAdapter(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y lo pasará al viewholder para que el obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto=contactos.get(position);
        contactoViewHolder.img_contact.setImageResource(contacto.getFoto());
        contactoViewHolder.txt_nombre_cv.setText(contacto.getNombre());
        contactoViewHolder.txt_telefono_cv.setText(contacto.getTelefono());

        contactoViewHolder.img_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(activity,DetalleContactoActivity.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_contact;
        private TextView txt_nombre_cv;
        private TextView txt_telefono_cv;
        public ContactoViewHolder(View itemView) {
            super(itemView);
            img_contact=(ImageView)itemView.findViewById(R.id.img_contact);
            txt_nombre_cv=(TextView)itemView.findViewById(R.id.txt_nombre_cv);
            txt_telefono_cv=(TextView)itemView.findViewById(R.id.txt_telefono_cv);
        }
    }
}
