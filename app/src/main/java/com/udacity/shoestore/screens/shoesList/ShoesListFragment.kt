package com.udacity.shoestore.screens.shoesList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoesListFragment : Fragment() {


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