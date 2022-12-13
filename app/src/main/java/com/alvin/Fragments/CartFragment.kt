package com.alvin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alvin.R
import com.alvin.databinding.FragmentCartBinding
import com.alvin.databinding.FragmentItemDetailBinding

class CartFragment : Fragment() {
    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

       // setupRecyclerView()


        return root
    }

}