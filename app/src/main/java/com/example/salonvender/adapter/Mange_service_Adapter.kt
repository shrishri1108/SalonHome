package com.example.salonvender.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.salonvender.R
import com.example.salonvender.databinding.ManageServicesItemsBinding
import com.example.salonvender.model.Manage_service_model

class Mange_service_Adapter(val context: Context, val list: List<Manage_service_model>) :
    RecyclerView.Adapter<Mange_service_Adapter.ViewHOlder>() {




    inner class ViewHOlder(var binding: ManageServicesItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHOlder {
        var binding:ManageServicesItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.manage_services_items,parent,false)
        return ViewHOlder(binding)
    }

    override fun onBindViewHolder(holder: ViewHOlder, position: Int) {
        holder.binding.item = list[position]
        holder.binding.kaichi.setImageResource(list[position].image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
