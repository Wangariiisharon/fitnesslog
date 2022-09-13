package dev.mwangi.fitnesslog

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    var message:String,
    @SerializedName("accessToken") var accessToken:String,
    @SerializedName("userId")var userId:String,
    @SerializedName("profileId")var profileId:String

)
