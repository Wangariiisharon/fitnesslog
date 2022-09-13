package dev.mwangi.fitnesslog.ui

import ViewModel.UserViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.mwangi.fitnesslog.ApiClient
import dev.mwangi.fitnesslog.ApiInterface
import dev.mwangi.fitnesslog.databinding.ActivitySignUpBinding
import dev.mwangi.fitnesslog.models.RegisterRequest
import dev.mwangi.fitnesslog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding
   val userViewModel:UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            validate()
        }
        }
 fun validate(){
     var password=binding.etPassword.text.toString()
     var confirm=binding.etConfirm.text.toString()
     var firstname=binding.etFirstName.text.toString()
     var lastname=binding.etLastName.text.toString()

     var error=false


     if (password.isBlank()){
      binding.tilPassword.error="This field must be filled"
     }
     if (password!=confirm){
     binding.tilConfirm.error="Passwords do not match"
     }
     if (firstname.isBlank()){
     binding.tilFirstName.error="This field must be filled"
     }
     if(lastname.isBlank()){
    binding.tilLastName.error="This field must be filled"
     }
     if(confirm.isBlank()){
         binding.tilConfirm.error="Passwords do not match"
     }
     if(!error){
         binding.pvRegister.visibility= View.VISIBLE
         var registerRequest = RegisterRequest(firstname, lastname, password)
        userViewModel.register(registerRequest)
     }
 }

    override fun onResume() {
        super.onResume()
        userViewModel.loginLiveData.observe(this, Observer{ registerResponse->
            Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()

            startActivity(Intent(baseContext,HomeActivity::class.java))

        })
        userViewModel.loginError.observe(this, Observer { errorMsg->
            Toast.makeText(baseContext,errorMsg,Toast.LENGTH_LONG).show()
        }
        )

    }

}


}
