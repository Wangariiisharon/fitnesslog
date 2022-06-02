package dev.mwangi.fitnesslog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var  tvSignUp:TextView
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var btnLogIn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        tvSignUp=findViewById(R.id.tvSignUp)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        btnLogIn=findViewById(R.id.btnLogIn)

        tvSignUp.setOnClickListener {
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
      btnLogIn.setOnClickListener {
          validateLogIn()
      }
        }

        fun validateLogIn(){
            val email=etEmail.text.toString()
            val password=etPassword.text.toString()
            if (email.isBlank()){
                etEmail.error="email is required"
            }
            if (password.isBlank()){
                etPassword.error="password is required"
            }
        }


    }
