package com.alvin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.alvin.Adapter.Crust_Optionadapter
import com.alvin.Adapter.ItemSizes_adapter
import com.alvin.Adapter.ItemTopping_adapter
import com.alvin.ModelClasses.CrustOptions
import com.alvin.ModelClasses.ItemSizes
import com.alvin.ModelClasses.Topiing_model
import com.alvin.R
import com.alvin.databinding.FragmentItemDetailBinding

class Item_Detail : Fragment() {

    private var _binding: FragmentItemDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()

        return root

    }


    private fun setupRecyclerView() {

        binding.rvItemSizes.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ItemSizes_adapter(createHeroList()) { item, position ->
                Toast.makeText(
                    activity,
                    "Clicked on actor: ${item.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }.itemAnimator as SimpleItemAnimator
        binding.rvItemCrust.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = Crust_Optionadapter(createCrustList()) { item, position ->


                Toast.makeText(
                    activity,
                    "Clicked on actor: ${item.name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        binding.rvTopping.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ItemTopping_adapter(createToppingList()) { item, position ->
            }
        }
    }

    private fun createHeroList(): ArrayList<ItemSizes> {
        return arrayListOf<ItemSizes>(
            ItemSizes(
                "Regular", "₹99",true,
                R.drawable.gal
            ),
            ItemSizes(
                "Medium", "₹199",false,
                R.drawable.gal
            ),
            ItemSizes(
                "Small", "₹199",false,
                R.drawable.gal
            ),
            ItemSizes(
                "Larger", "₹199",false,
                R.drawable.gal
            ),
            ItemSizes(
                "XXX", "₹199",false,
                R.drawable.gal
            ),
            ItemSizes(
                "XXL", "₹199",false,
                R.drawable.gal
            )
        )
    }

    private fun createCrustList(): ArrayList<CrustOptions> {
        return arrayListOf<CrustOptions>(
            CrustOptions(
                "New Hand", "Tossed",true
            ),
            CrustOptions(
                "Cheese", "Burst",false
            ),
            CrustOptions(
                "Classic", "Burst",false
            ),
            CrustOptions(
                "Cheese", "Burst",false
            ),
            CrustOptions(
                "Classic", "Burst",false
            ),
            CrustOptions(
                "Classic", "Burst",false
            )
        )
    }
    private fun createToppingList(): ArrayList<Topiing_model> {
        return arrayListOf<Topiing_model>(
            Topiing_model(
                "New Hand","₹199",false
            ),
            Topiing_model(
                "Cheese","₹199",false
            ),
            Topiing_model(
                "Classic", "₹199",false
            ),
            Topiing_model(
                "Cheese", "₹199",false
            ),
            Topiing_model(
                "Classic", "₹199",false
            ),
            Topiing_model(
                "Classic", "₹199",false
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addBtn.setOnClickListener {

            findNavController().navigate(R.id.action_item_Detail2_to_cartFragment)

        }

    }

}