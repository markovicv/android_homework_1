package com.example.rma_h1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(var username:String?, var password:String?) :Parcelable{
}