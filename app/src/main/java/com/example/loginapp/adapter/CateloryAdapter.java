package com.example.loginapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginapp.R;
import com.example.loginapp.models.Catelogy;

import java.util.List;

public class CateloryAdapter extends ArrayAdapter<Catelogy> {
    public CateloryAdapter(@NonNull Context context, int resource, @NonNull List<Catelogy> objects) {
        super(context, resource, objects);
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected,parent, false);
        TextView tvSelected = convertView.findViewById(R.id.tv_selected);

        Catelogy catelogy = this.getItem(position);
        if (catelogy != null){
            tvSelected.setText(catelogy.getName());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_catelogy,parent, false);
        TextView tvCatelogy = convertView.findViewById(R.id.tv_catelogy);

        Catelogy catelogy = this.getItem(position);
        if (catelogy != null){
            tvCatelogy.setText(catelogy.getName());
        }
        return convertView;
    }
}
