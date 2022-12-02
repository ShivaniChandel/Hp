package com.alvin.ModelClasses

import com.google.gson.annotations.SerializedName

class Data {

    @SerializedName("ID"                  ) var ID                : String? = null
    @SerializedName("user_login"          ) var userLogin         : String? = null
    @SerializedName("user_pass"           ) var userPass          : String? = null
    @SerializedName("user_nicename"       ) var userNicename      : String? = null
    @SerializedName("user_email"          ) var userEmail         : String? = null
    @SerializedName("user_url"            ) var userUrl           : String? = null
    @SerializedName("user_registered"     ) var userRegistered    : String? = null
    @SerializedName("user_activation_key" ) var userActivationKey : String? = null
    @SerializedName("user_status"         ) var userStatus        : String? = null
    @SerializedName("display_name"        ) var displayName       : String? = null
}