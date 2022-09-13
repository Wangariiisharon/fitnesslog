package ViewModel

import Repository.UserRepository
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mwangi.fitnesslog.LoginRequest
import dev.mwangi.fitnesslog.LoginResponse
import dev.mwangi.fitnesslog.models.RegisterRequest
import dev.mwangi.fitnesslog.models.RegisterResponse
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val userRepository= UserRepository()
    val loginLiveData=MutableLiveData<LoginResponse>()
    val loginError=MutableLiveData<String>()
    val registerLiveData=MutableLiveData<RegisterResponse>()
    val registerError=MutableLiveData<String>()

    fun login(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response=userRepository.logInUser(loginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body())
            }
            else{
                loginError.postValue(response.errorBody()?.string())
            }
        }
    }
    fun register(registerRequest: RegisterRequest){
        viewModelScope.launch{
            val response=userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                registerLiveData.postValue(response.body())
            }
            else{
                registerError.postValue(response.errorBody()?.string())
            }
        }
    }

}
//Middleman between tha Ui and tha repository.
//live data is amutable observable live data holder.

