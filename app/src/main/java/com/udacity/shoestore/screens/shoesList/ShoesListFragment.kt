package com.udacity.shoestore.screens.shoesList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.screens.detail.DetailViewModel
import com.udacity.shoestore.screens.login.LoginStartFragmentDirections
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [ShoesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("UNREACHABLE_CODE")
class ShoesListFragment : Fragment() {

    // Declaring DetailViewewModel
    private lateinit var viewModel: DetailViewModel

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
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel
        /** Methods for updating the UI **/
        viewModel.shoeCreated.observe(viewLifecycleOwner, Observer { createdNewShoe ->
            if (createdNewShoe) {
                Timber.i("CHACOTA: %s", viewModel.person)
            }
        })
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