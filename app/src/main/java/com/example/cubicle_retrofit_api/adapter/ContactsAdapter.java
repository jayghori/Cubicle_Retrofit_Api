package com.example.cubicle_retrofit_api.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cubicle_retrofit_api.R;
import com.example.cubicle_retrofit_api.model.Contacts;
import com.example.cubicle_retrofit_api.model.Root;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    List<Contacts> contactsList;
    Context context;

    public ContactsAdapter(List<Contacts> contactsList, Context context) {
        this.contactsList = contactsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_contacts,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ContactsAdapter.ViewHolder holder, int position) {

        holder.tvName.setText("contact :- "+contactsList.get(position).getName());
        holder.tvEmail.setText(""+contactsList.get(position).getEmail());
        holder.tvPhone.setText(""+contactsList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName,tvEmail,tvPhone;
        public ViewHolder(@NonNull  View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            tvPhone=itemView.findViewById(R.id.tvPhone);
            tvEmail=itemView.findViewById(R.id.tvEmail);
        }
    }
}
