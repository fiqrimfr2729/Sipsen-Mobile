package com.example.sipsen.Api

import com.example.sipsen.Response.Respone
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BaseAPI {

    @FormUrlEncoded
    @POST("loginSiswa")
    fun login(@Field("nis") nis: String?,
              @Field("password") password: String?): Call<Respone>
}