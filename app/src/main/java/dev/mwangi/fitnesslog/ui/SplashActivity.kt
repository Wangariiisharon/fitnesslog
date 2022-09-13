package dev.mwangi.fitnesslog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        var accesstoken=sharedPrefs.getString("ACCESS_TOKEN","").toString()
        

        val intent= Intent(this, LogInActivity::class.java)
        startActivity(intent)
        finish()
    }
}