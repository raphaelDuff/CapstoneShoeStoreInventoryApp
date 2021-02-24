package com.udacity.shoestore.screens.shoesList

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.screens.detail.DetailViewModel
import timber.log.Timber


class ShoesListFragment : Fragment() {


    private val viewModel: DetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoesListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoes_list, container, false
        )

        binding.buttonFloatAddShoe.setOnClickListener {
            findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToDetailFragment())
        }
        setHasOptionsMenu(true)
        viewModel.shoeList.observe(viewLifecycleOwner) { it ->
            it.forEach {

                val itemView = TextView(this.context)
                val itemListText: String = getString(
                    R.string.item_list,
                    it.person,
                    it.name,
                    it.size,
                    it.company,
                    it.description
                )

                Timber.i("Passou por aqui")
                itemView.text = itemListText
                itemView.textSize = 18F
                binding.LinearLayoutScrollView.addView(itemView)
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}