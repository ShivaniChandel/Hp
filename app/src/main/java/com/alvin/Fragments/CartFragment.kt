package com.alvin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvin.Adapter.Cart_adapter
import com.alvin.ModelClasses.ItemSizes
import com.alvin.R
import com.alvin.databinding.FragmentCartBinding

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

        setupRecyclerView()


        return root
    }

    private fun setupRecyclerView() {

        binding.rvCart.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = Cart_adapter(createHeroList()) { item, position ->
                Toast.makeText(
                    activity,
                    "Clicked on actor: ${item.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun createHeroList(): ArrayList<ItemSizes> {
        return arrayListOf<ItemSizes>(
            ItemSizes(
                "Regular", "₹99", true,
                R.drawable.gal
            ),
            ItemSizes(
                "Medium", "₹199", false,
                R.drawable.gal
            ),
            ItemSizes(
                "Small", "₹199", false,
                R.drawable.gal
            ),
            ItemSizes(
                "Larger", "₹199", false,
                R.drawable.gal
            ),
            ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ), ItemSizes(
                "XXX", "₹199", false,
                R.drawable.gal
            ),
            ItemSizes(
                "XXL", "₹199", false,
                R.drawable.gal
            )
        )
    }
}