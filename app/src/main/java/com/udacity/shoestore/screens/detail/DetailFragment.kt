package com.udacity.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class DetailFragment : Fragment() {

    private val viewModel: DetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )
        Timber.i("Called ViewModelProvider!")

        binding.buttonBuy.setOnClickListener {

            binding.apply {
                if (
                    editTextPerson.text.isNotEmpty() &&
                    editTextShoeName.text.isNotEmpty() &&
                    editTextShoeNumber.text.isNotEmpty() &&
                    editTextTCompany.text.isNotEmpty() &&
                    editTextDescription.text.isNotEmpty()
                ) {
                    val shoe = Shoe(
                        editTextPerson.text.toString(),
                        editTextShoeName.text.toString(),
                        editTextShoeNumber.text.toString(),
                        editTextTCompany.text.toString(),
                        editTextDescription.text.toString()
                    )

                    viewModel.addShoeToList(shoe)
                }
            }
            goToListScreen()
        }

        binding.buttonCancel.setOnClickListener {
            goToListScreen()
        }
        return binding.root
    }


    private fun goToListScreen() {
        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoesListFragment())
    }

}