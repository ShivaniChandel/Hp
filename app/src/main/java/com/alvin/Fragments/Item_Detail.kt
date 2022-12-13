package com.alvin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvin.Adapter.Crust_Optionadapter
import com.alvin.Adapter.ItemSizes_adapter
import com.alvin.ModelClasses.CrustOptions
import com.alvin.ModelClasses.ItemSizes
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
        }
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
    }

    private fun createHeroList(): ArrayList<ItemSizes> {
        return arrayListOf<ItemSizes>(
            ItemSizes(
                "Ajay Devgan", "123",
                R.drawable.gal
            ),
            ItemSizes(
                "Chris Hemsworth", "123",
                R.drawable.gal
            ),
            ItemSizes(
                "Daniel Craig", "123",
                R.drawable.gal
            ),
            ItemSizes(
                "Dwayne Johnson", "123",
                R.drawable.gal
            ),
            ItemSizes(
                "Tom Hiddlestone", "123",
                R.drawable.gal
            ),
            ItemSizes(
                "Tony Stark", "123",
                R.drawable.gal
            )
        )
    }

    private fun createCrustList(): ArrayList<CrustOptions> {
        return arrayListOf<CrustOptions>(
            CrustOptions(
                "Ajay Devgan", "123"
            ),
            CrustOptions(
                "Chris Hemsworth", "123"
            ),
            CrustOptions(
                "Daniel Craig", "123"
            ),
            CrustOptions(
                "Dwayne Johnson", "123"
            ),
            CrustOptions(
                "Tom Hiddlestone", "123"
            ),
            CrustOptions(
                "Tony Stark", "123"
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