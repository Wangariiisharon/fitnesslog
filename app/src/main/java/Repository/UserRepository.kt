package Repository

import dev.mwangi.fitnesslog.ApiClient
import dev.mwangi.fitnesslog.ApiInterface
import dev.mwangi.fitnesslog.LoginRequest
import dev.mwangi.fitnesslog.LoginResponse
import dev.mwangi.fitnesslog.models.RegisterRequest
import dev.mwangi.fitnesslog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun logInUser(loginRequest: LoginRequest): Response<LoginResponse>
    = withContext(Dispatchers.IO){
        val response=apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterResponse>
            = withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequest)
        return@withContext response
    }
//Suspend means that it stops executing and wait for a response.

}
