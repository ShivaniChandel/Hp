package com.alvin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.CrustOptions
import com.alvin.ModelClasses.ItemSizes
import com.alvin.databinding.AdapterItemCrustBinding

class Crust_Optionadapter(
    private val heroList: ArrayList<CrustOptions>,
    private val listener: (CrustOptions, Int) -> Unit
) :
    RecyclerView.Adapter<Crust_Optionadapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = AdapterItemCrustBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroList[position])
        holder.itemView.setOnClickListener { listener(heroList[position], position) }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(var itemBinding: AdapterItemCrustBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(crustOptions: CrustOptions) {
            itemBinding.nameTxt.text = crustOptions.name
            itemBinding.typeTxt.text = crustOptions.type
        }
    }
}
