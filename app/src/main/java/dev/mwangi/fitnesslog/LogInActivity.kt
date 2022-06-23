package dev.mwangi.fitnesslog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.mwangi.fitnesslog.databinding.ActivityHomeBinding
import dev.mwangi.fitnesslog.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.tvSignUp.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
      binding.btnLogIn.setOnClickListener {
          validateLogIn()
          val intent=Intent(this,HomeActivity::class.java)
          startActivity(intent)
      }
        }

        fun validateLogIn(){
            val email=binding.etEmail.text.toString()
            val password=binding.etPassword.text.toString()

//            etEmail.addTextChangedListener()
            if (email.isBlank()){
                binding.etEmail.error="email is required"
            }
            if (password.isBlank()){
                binding.etPassword.error="password is required"
            }
        }


    }
