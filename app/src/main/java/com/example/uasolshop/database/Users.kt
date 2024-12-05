package com.example.uasolshop.database

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("_id")
    val id: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("role")
    val role: String
)
