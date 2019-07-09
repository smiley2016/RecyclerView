package com.example.fragmentrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactListRecyclerViewAdapter extends RecyclerView.Adapter<ContactListRecyclerViewAdapter.ContactListViewHolder> {

    private ArrayList<ContactData> list;

    public ContactListRecyclerViewAdapter(ArrayList<ContactData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ContactListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View newView = inflater.inflate(R.layout.list_element, parent, false);
        return new ContactListViewHolder(newView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListViewHolder holder, int position) {
        ContactData contact = list.get(position);
        holder.name.setText(contact.getName());
        holder.number.setText(contact.getNumber());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContactListViewHolder extends RecyclerView.ViewHolder {
        private TextView name, number;
        private CheckBox check;

        public ContactListViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contactName);
            number = itemView.findViewById(R.id.phoneNumber);
            check = itemView.findViewById(R.id.contactCheckBox);
        }
    }
}
