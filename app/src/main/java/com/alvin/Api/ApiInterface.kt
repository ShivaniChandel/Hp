package com.alvin.Api

import com.alvin.ModelClasses.LoginModel
import com.alvin.ModelClasses.RegisterModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    //Login Api 1
    @FormUrlEncoded
    @POST("login")
    fun getLogin(@Field("email") username:String, @Field("password") password:String ): Call<LoginModel>


    @FormUrlEncoded
    @POST("register")
    fun getRegister(@Field("username") username:String,@Field("phone_number") phone_number:String,@Field("email") email:String, @Field("password") password:String ): Call<RegisterModel>

}