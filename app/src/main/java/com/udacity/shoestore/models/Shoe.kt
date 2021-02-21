package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var person: String, var name: String, var size: String, var company: String,
                var description: String) : Parcelable