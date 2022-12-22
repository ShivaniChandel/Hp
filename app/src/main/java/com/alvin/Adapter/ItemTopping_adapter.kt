package com.alvin.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.Topiing_model
import com.alvin.databinding.AdapterItemToppingBinding

class ItemTopping_adapter(
    private val heroList: ArrayList<Topiing_model>,
    private val listener: (Topiing_model, Int) -> Unit
) :
    RecyclerView.Adapter<ItemTopping_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            AdapterItemToppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroList[position])
        holder.itemView.setOnClickListener {

            listener(heroList[position], position)

            if (heroList.get(position).selected) {
                heroList.set(
                    position,
                    Topiing_model(heroList.get(position).name, heroList.get(position).price, false)
                )
            } else {
                heroList.set(
                    position,
                    Topiing_model(heroList.get(position).name, heroList.get(position).price, true)
                )
            }
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(var itemBinding: AdapterItemToppingBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(topiingModel: Topiing_model) {
            itemBinding.toppingname.text = topiingModel.name

            if (topiingModel.selected) {
                itemBinding.checkTopping.isChecked = true
            } else {
                itemBinding.checkTopping.isChecked = false
            }

        }
    }
}