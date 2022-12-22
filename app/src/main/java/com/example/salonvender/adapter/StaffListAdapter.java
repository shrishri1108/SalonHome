package com.example.salonvender.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.salonvender.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffListAdapter extends ArrayAdapter {

    private Context context;
    private int layoutResourceId;
    private int [] staff_image= {R.drawable.aman_suri,R.drawable.angel_kaur,R.drawable.alluarjun,R.drawable.durgesh_sharma,R.drawable.gaurav_rjput,R.drawable.iqbal_kureshi,R.drawable.kajal_kher};
    private List<String> data ;
    public StaffListAdapter(@NonNull Context context, int resource, List<String> data) {
        super(context, resource, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staff_lays, null, true);
        }
        TextView staff_name= view.findViewById(R.id.staff_name);
        ImageView staff_images= view.findViewById(R.id.staff_image);
        staff_name.setText(data.get(position));
        staff_images.setImageResource(staff_image[position]);
        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_staff_lays, parent, true);
        }
        TextView staff_name= view.findViewById(R.id.staff_name);
        ImageView staff_images= view.findViewById(R.id.staff_image);
        staff_name.setText(data.get(position));
        staff_images.setImageResource(staff_image[position]);
        return view;
    }

    static class ViewHolder {
        TextView staff_name;
        ImageView staff_image;
    }
    class ImageItem {
        String staff_name;
        String staff_image;

        public String getStaff_image() {
            return staff_image;
        }

        public String getStaff_name() {
            return staff_name;
        }
    }
}
