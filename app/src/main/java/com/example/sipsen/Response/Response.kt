package com.example.sipsen.Response

import com.google.gson.annotations.SerializedName

data class Respone(

    @SerializedName("value")
    val value: Int? = null,

    @SerializedName("message")
    val message: String? = null
)