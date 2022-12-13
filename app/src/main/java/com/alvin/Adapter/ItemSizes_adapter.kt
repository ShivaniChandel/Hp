package com.alvin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.ItemSizes
import com.alvin.databinding.AdapterItemSizesBinding

class ItemSizes_adapter(
    private val heroList: ArrayList<ItemSizes>,
    private val listener: (ItemSizes, Int) -> Unit
) :
    RecyclerView.Adapter<ItemSizes_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = AdapterItemSizesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroList[position])
        holder.itemView.setOnClickListener { listener(heroList[position], position) }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(var itemBinding: AdapterItemSizesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(itemSizes: ItemSizes) {
            itemBinding.iconImg.setImageResource(itemSizes.image)
            itemBinding.sizesName.text = itemSizes.name
            itemBinding.prizeTxt.text = itemSizes.prize
        }
    }
}
