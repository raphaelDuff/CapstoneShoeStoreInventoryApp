package com.udacity.shoestore.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoesList.ShoesListFragmentDirections
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var newShoe: Shoe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )
        Timber.i("Called ViewModelProvider!")
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel

        binding.buttonBuy.setOnClickListener {
            newShoe = Shoe(
                binding.editTextPerson.text.toString(),
                binding.editTextShoeName.text.toString(),
                binding.editTextShoeNumber.text.toString(),
                binding.editTextTCompany.text.toString(),
                binding.editTextDescription.text.toString()
            )
            Timber.i("PERSON NAME: %s", newShoe.person)
            viewModel.saveShoesValues(newShoe.person, newShoe.name, newShoe.size, newShoe.company, newShoe.description)
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoesListFragment())
        }


        return binding.root
    }

}