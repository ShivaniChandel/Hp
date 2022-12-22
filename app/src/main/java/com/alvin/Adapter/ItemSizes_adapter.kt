package com.alvin.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.ItemSizes
import com.alvin.R
import com.alvin.databinding.AdapterItemSizesBinding

class ItemSizes_adapter(
    private val heroList: ArrayList<ItemSizes>, private val listener: (ItemSizes, Int) -> Unit
) : RecyclerView.Adapter<ItemSizes_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = AdapterItemSizesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroList[position])

        holder.itemView.setOnClickListener {
            Log.i("TAG", "=====position====" + position)

            if (heroList.get(position).selected) {

                //if(heroList.any { it.selected == true })
                for (i in 0 until heroList.size) {
                    if (i == position) {
                        heroList.set(
                            position,
                            ItemSizes(
                                heroList.get(position).name,
                                heroList.get(position).prize,
                                false,
                                heroList.get(position).image
                            )
                        )
                    } else {
                        heroList.set(
                            i,
                            ItemSizes(
                                heroList.get(i).name,
                                heroList.get(i).prize,
                                false,
                                heroList.get(i).image
                            )
                        )
                    }
                }
                heroList.set(
                    position,
                    ItemSizes(
                        heroList.get(position).name,
                        heroList.get(position).prize,
                        false,
                        heroList.get(position).image
                    )
                )

            } else {

                for (i in 0 until heroList.size) {
                    if (i == position) {
                        heroList.set(
                            position,
                            ItemSizes(
                                heroList.get(position).name,
                                heroList.get(position).prize,
                                true,
                                heroList.get(position).image
                            )
                        )
                    } else {
                        heroList.set(
                            i,
                            ItemSizes(
                                heroList.get(i).name,
                                heroList.get(i).prize,
                                false,
                                heroList.get(i).image
                            )
                        )
                    }
                }
            }

            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(var itemBinding: AdapterItemSizesBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(itemSizes: ItemSizes) {
            Log.i("TAG", "=====post====" + itemSizes.selected)
            if (itemSizes.selected) {
                itemBinding.sizeContainer.setBackgroundResource(R.drawable.bg_yellow)
                itemBinding.selectedImg.visibility = View.VISIBLE
            } else {
                itemBinding.sizeContainer.setBackgroundResource(R.drawable.bg_white)
                itemBinding.selectedImg.visibility = View.GONE
            }
            //    itemBinding.iconImg.setImageResource(itemSizes.image)
            itemBinding.sizesName.text = itemSizes.name
            itemBinding.prizeTxt.text = itemSizes.prize

        }
    }
}
