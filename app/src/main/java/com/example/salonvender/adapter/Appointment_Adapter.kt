package com.example.salonvender.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.salonvender.R
import com.example.salonvender.databinding.AppointmentRecyclerviewItemBinding
import com.example.salonvender.model.Model_appointment_item

class Appointment_Adapter(var context: Context, var list: List<Model_appointment_item>) :
    RecyclerView.Adapter<Appointment_Adapter.ViewHolder>() {


    inner class ViewHolder(var binding: AppointmentRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var binding:AppointmentRecyclerviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.appointment_recyclerview_item,parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val apiList: Model_appointment_item = list[position]
        holder.binding.customerProfile.setImageDrawable(ContextCompat.getDrawable(context,apiList.profile))
        holder.binding.name.text = apiList.name
        holder.binding.atHome.text = apiList.at_home
        holder.binding.online.text = apiList.online
        holder.binding.HaircutHairSpa1.text = apiList.hairecut
        holder.binding.Male.text = apiList.male
        holder.binding.distance.text = apiList.distance
        holder.binding.today.text = apiList.today
        holder.binding.time.text = apiList.time
    }

    override fun getItemCount(): Int {
        return list.size
    }
}