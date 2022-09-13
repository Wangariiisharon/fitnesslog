package dev.mwangi.fitnesslog.ui

import ViewModel.UserViewModel
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.mwangi.fitnesslog.ApiClient
import dev.mwangi.fitnesslog.ApiInterface
import dev.mwangi.fitnesslog.LoginRequest
import dev.mwangi.fitnesslog.LoginResponse
import dev.mwangi.fitnesslog.databinding.ActivityLogInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    lateinit var sharedRefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedRefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)




        binding.tvSignUp.setOnClickListener {
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
      binding.btnLogIn.setOnClickListener {
          validateLogIn()
          val intent=Intent(this, HomeActivity::class.java)
          startActivity(intent)
      }
        }

    override fun onResume() {
        super.onResume()
        userViewModel.loginLiveData.observe(this, Observer { loginResponse->
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            persistLogInDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))

        })
        userViewModel.loginError.observe(this, Observer { errorMsg->
            Toast.makeText(baseContext,errorMsg,Toast.LENGTH_LONG).show()
        }
        )

    }
        fun validateLogIn(){
            val email=binding.etEmail.text.toString()
            val password=binding.etPassword.text.toString()
            var error=false

//            etEmail.addTextChangedListener()
            if (email.isBlank()){
                error=true
                binding.etEmail.error="email is required"
            }
            if (password.isBlank()){
                error=true
                binding.etPassword.error="password is required"
            }
            if (!error){
                val loginrequest=LoginRequest(email,password)
                userViewModel.login(loginrequest)

            }
        }


    fun persistLogInDetails(loginResponse: LoginResponse){
        val editor=sharedRefs.edit()
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.commit()
    }

    }
