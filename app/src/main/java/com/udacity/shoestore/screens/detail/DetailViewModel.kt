package com.udacity.shoestore.screens.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class DetailViewModel : ViewModel() {

    // Internal
    private val _person = MutableLiveData<String>()
    // External
    val person : LiveData<String>
        get() = _person

    // Internal
    private val _shoeName = MutableLiveData<String>()
    // External
    val shoeName : LiveData<String>
        get() = _shoeName

    // Internal
    private val _shoeSize = MutableLiveData<String>()
    // External
    val shoeSize : LiveData<String>
        get() = _shoeSize

    // Internal
    private val _company = MutableLiveData<String>()
    // External
    val company : LiveData<String>
        get() = _company

    // Internal
    private val _description = MutableLiveData<String>()
    // External
    val description : LiveData<String>
        get() = _description

    // Internal
    private val _shoeCreated = MutableLiveData<Boolean>()
    // External
    val shoeCreated : LiveData<Boolean>
        get() = _shoeCreated

    init {
        _shoeCreated.value = false
        Timber.i("DetailViewModelCreated")
    }

    fun saveShoesValues(shoeFragPerson: String, shoeFragName: String, shoeFragSize: String,
    shoeFragCompany: String, shoeFragDescription: String) {
        //_person.value =  shoeFragPerson
        _shoeName.value = shoeFragName
        _shoeSize.value = shoeFragSize
        _company.value = shoeFragCompany
        _description.value = shoeFragDescription
        Timber.i("vou tentar chamar o validator aqui")
        shoesCreatedValidator()
        Timber.i("Shoes created %s", _shoeCreated.value)
    }

    private fun shoesCreatedValidator() {
        _shoeCreated.value = true
    }
}