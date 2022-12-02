package com.alvin.ModelClasses

import com.google.gson.annotations.SerializedName

class RegisterModel {
    @SerializedName("code" ) var code  : String?           = null
    @SerializedName("message" ) var message  : String?           = null
}