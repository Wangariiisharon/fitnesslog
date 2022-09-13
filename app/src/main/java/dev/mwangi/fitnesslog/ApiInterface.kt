package dev.mwangi.fitnesslog

import dev.mwangi.fitnesslog.models.RegisterRequest
import dev.mwangi.fitnesslog.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
    @POST("/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}

