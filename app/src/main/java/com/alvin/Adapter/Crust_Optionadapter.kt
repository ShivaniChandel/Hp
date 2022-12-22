package com.alvin.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.CrustOptions
import com.alvin.ModelClasses.ItemSizes
import com.alvin.R
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
        holder.itemView.setOnClickListener {
            //listener(heroList[position], position)

            Log.i("TAG", "=====position====" + position)

            if (heroList.get(position).selected) {

                //if(heroList.any { it.selected == true })
                for (i in 0 until heroList.size) {
                    if (i == position) {
                        heroList.set(
                            position,
                            CrustOptions(
                                heroList.get(position).name,
                                heroList.get(position).type,
                                false
                            )
                        )
                    } else {
                        heroList.set(
                            i,
                            CrustOptions(
                                heroList.get(i).name,
                                heroList.get(i).type,
                                false
                            )
                        )
                    }
                }
                heroList.set(
                    position,
                    CrustOptions(
                        heroList.get(position).name,
                        heroList.get(position).type,
                        false
                    )
                )

            } else {

                for (i in 0 until heroList.size) {
                    if (i == position) {
                        heroList.set(
                            position,
                            CrustOptions(
                                heroList.get(position).name,
                                heroList.get(position).type,
                                true
                            )
                        )
                    } else {
                        heroList.set(
                            i,
                            CrustOptions(
                                heroList.get(i).name,
                                heroList.get(i).type,
                                false
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

    class ViewHolder(var itemBinding: AdapterItemCrustBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(crustOptions: CrustOptions) {
            if (crustOptions.selected) {
                itemBinding.crustContainer.setBackgroundResource(R.drawable.bg_yellow)
                itemBinding.selectedImg.visibility = View.VISIBLE
            } else {
                itemBinding.crustContainer.setBackgroundResource(R.drawable.bg_white)
                itemBinding.selectedImg.visibility = View.GONE
            }
            itemBinding.nameTxt.text = crustOptions.name
            itemBinding.typeTxt.text = crustOptions.type
        }
    }
}
