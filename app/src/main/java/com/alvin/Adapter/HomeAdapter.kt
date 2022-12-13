package com.alvin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.alvin.ModelClasses.Home_ItemViewModel
import com.alvin.R

class HomeAdapter(private val mList: List<Home_ItemViewModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_home_screen, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
        holder.banner.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.name.text = ItemsViewModel.text

        holder.touchCard.setOnClickListener {

            onItemClickListener?.let { it(ItemsViewModel) } // Make ViewHolder clickable

        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val touchCard: CardView = itemView.findViewById(R.id.touchCard)
        val banner: ImageView = itemView.findViewById(R.id.banner_img)
        val name: TextView = itemView.findViewById(R.id.name_txt)
    }

    private var onItemClickListener: ((Home_ItemViewModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (Home_ItemViewModel) -> Unit) {
        onItemClickListener = listener
    }
}