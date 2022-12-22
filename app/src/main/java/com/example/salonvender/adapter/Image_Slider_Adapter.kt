package com.example.salonvender.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.salonvender.R
import com.example.salonvender.databinding.BannerLayoutBinding
import com.example.salonvender.model.Banner_Model
import com.smarteist.autoimageslider.SliderViewAdapter

class Image_Slider_Adapter(val context: Context, val list: List<Banner_Model>) :
    SliderViewAdapter<Image_Slider_Adapter.ViewHolder>() {


    inner class ViewHolder(var binding: BannerLayoutBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        fun bind(ban: Int) {
            binding.banner.setImageDrawable(ContextCompat.getDrawable(context,ban))
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {

        val binding: BannerLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent?.context),
            R.layout.banner_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        viewHolder!!.bind(list[position].banner)


//        Glide.with(viewHolder.itemView)
//            .load(Banner_Model.getImageUrl())
//            .fitCenter()
//            .into(viewHolder.imageViewBackground);
    }

    override fun getCount(): Int {
        return list.size
    }


}