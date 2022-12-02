package com.alvin.ModelClasses

import com.google.gson.annotations.SerializedName

class LoginModel {
    @SerializedName("data"    ) var data    : Data?             = Data()
  /*  @SerializedName("ID"      ) var ID      : Int?              = null,
    @SerializedName("caps"    ) var caps    : Caps?             = Caps(),
    @SerializedName("cap_key" ) var capKey  : String?           = null,
    @SerializedName("roles"   ) var roles   : ArrayList<String> = arrayListOf(),
    @SerializedName("allcaps" ) var allcaps : Allcaps?          = Allcaps(),
    @SerializedName("filter"  ) var filter  : String?           = null*/
}
