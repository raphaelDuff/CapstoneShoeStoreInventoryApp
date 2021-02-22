package com.udacity.shoestore.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class DetailViewModel : ViewModel() {

    private val shoesList = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = shoesList
        Timber.i("DetailViewModelCreated")
    }

    fun addShoeToList(shoe: Shoe) {
        shoesList.add(shoe)
    }

}