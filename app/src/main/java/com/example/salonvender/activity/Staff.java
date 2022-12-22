package com.example.salonvender.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.salonvender.adapter.StaffListAdapter;
import com.example.salonvender.databinding.ActivityStaffBinding;

import java.util.ArrayList;
import java.util.List;

public class Staff extends AppCompatActivity {

    private ActivityStaffBinding staffBinding;
    private List<String> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        staffBinding= ActivityStaffBinding.inflate(getLayoutInflater());
        setContentView(staffBinding.getRoot());
        data.add("Aman Suri");
        data.add("Angel Kaur");
        data.add("Allu Arjun");
        data.add("Durgesh Sharma");
        data.add("Gaurav Rajput");
        data.add("Iqbal Kurashi");
        data.add("Kajal Kher");
        StaffListAdapter adapter=new StaffListAdapter(this,0,data);
        staffBinding.staffList.setAdapter(adapter);
    }
}