package com.example.uasolshop.network

import com.example.uasolshop.database.ApiResponseCheckUsername
import com.example.uasolshop.database.Products
import com.example.uasolshop.database.Users
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @POST("users")
    fun createUser(@Body user: Users): Call<Users>
    @GET("users")
    fun getAllUsers(): Call<List<Users>>
    @GET("produkGB")
    fun getAllProducts(): Call<List<Products>>

    @POST("produkGB")
    fun uploadProduk(@Body rawJson: RequestBody): Call<Products>

    @POST("produkGB/{id}")
    fun updateProduk(@Path("id") bookId:String, @Body rawJson: RequestBody): Call<Products>

    @DELETE("produkGB/{id}")
    fun deleteProduct(
        @Path("id") id: String
    ):Call<Void>
//            Call<Void>
//    Call<Products>
}