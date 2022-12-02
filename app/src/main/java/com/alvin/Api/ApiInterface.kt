package com.alvin.Api

import com.alvin.ModelClasses.LoginModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    //Login Api 1
    @FormUrlEncoded
    @POST("login")
    fun getLogin(@Field("username") username:String, @Field("password") password:String ): Call<LoginModel>

}