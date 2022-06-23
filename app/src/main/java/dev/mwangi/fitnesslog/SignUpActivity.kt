package dev.mwangi.fitnesslog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import dev.mwangi.fitnesslog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
   lateinit var binding: ActivitySignUpBinding

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




 }
    }
