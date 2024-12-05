package com.example.uasolshop.database

import com.google.gson.annotations.SerializedName

data class ApiResponseCheckUsername(
    @SerializedName("existsusername")
    val existsusername: Boolean,
)
