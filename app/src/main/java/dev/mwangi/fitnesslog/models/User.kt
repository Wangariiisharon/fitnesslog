package dev.mwangi.fitnesslog.models

import com.google.gson.annotations.SerializedName

data class user(
    @SerializedName("phone_number") var phoneNumber:String,
    @SerializedName("first_name" )var firstName:String,
    @SerializedName("user_id")var userId:String,
    @SerializedName("last_name") var lastName:String,
    @SerializedName("email" )var email:String,
)
