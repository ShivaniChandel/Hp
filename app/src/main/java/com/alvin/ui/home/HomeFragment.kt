package com.alvin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.alvin.Adapter.HomeAdapter
import com.alvin.ModelClasses.Home_ItemViewModel
import com.alvin.R
import com.alvin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()




    }

    var clickdata: Home_ItemViewModel? = null
    fun setAdapter() {
// this creates a vertical layout Manager
        _binding?.rvList?.layoutManager = GridLayoutManager(activity, 2)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Home_ItemViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(Home_ItemViewModel(R.drawable.gal, "Pizza " + i))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = HomeAdapter(data)

        // Setting the Adapter with the recyclerview
        _binding?.rvList?.adapter = adapter

        adapter.setOnItemClickListener {
           // clickdata = it
            findNavController().navigate(R.id.action_nav_home_to_item_Detail2)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}