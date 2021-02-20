package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginStartBinding


class LoginStartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginStartBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_start, container, false)
        binding.button.setOnClickListener {
            findNavController().navigate(LoginStartFragmentDirections.actionLoginStartFragment2ToWelcomeFragment())
        }
        binding.newAccountButton.setOnClickListener {
            findNavController().navigate(LoginStartFragmentDirections.actionLoginStartFragment2ToWelcomeFragment())
        }
        return binding.root
    }
}