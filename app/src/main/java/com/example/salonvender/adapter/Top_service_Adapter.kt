package com.example.salonvender.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.salonvender.R

import com.example.salonvender.databinding.TopServicesItemBinding

import com.example.salonvender.model.Top_service_Model

class Top_service_Adapter(var context: Context, var list: List<Top_service_Model>) :
    RecyclerView.Adapter<Top_service_Adapter.ViewHolder>() {


    inner class ViewHolder(var binding: TopServicesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var binding: TopServicesItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.top_services_item, parent, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val apiList: Top_service_Model = list[position]
        holder.binding.image.setImageDrawable(ContextCompat.getDrawable(context,apiList.image))
        holder.binding.text.text = apiList.text

    }


    override fun getItemCount(): Int {
        return list.size
    }
}
