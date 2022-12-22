package com.alvin.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.ItemSizes
import com.alvin.databinding.AdapterCartLayoutBinding
import com.google.android.material.shape.CornerFamily

class Cart_adapter(
    private val heroList: ArrayList<ItemSizes>, private val listener: (ItemSizes, Int) -> Unit
) : RecyclerView.Adapter<Cart_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = AdapterCartLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroList[position])

    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(var itemBinding: AdapterCartLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(itemSizes: ItemSizes) {
            Log.i("TAG", "=====post====" + itemSizes.selected)
            // set appearance
            itemBinding.itemImg.setShapeAppearanceModel(
                itemBinding.itemImg.getShapeAppearanceModel().toBuilder().setAllCorners(
                    CornerFamily.ROUNDED,
                    30F
                ).build()
            )
        }
    }
}
