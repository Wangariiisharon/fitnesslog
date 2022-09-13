package dev.mwangi.fitnesslog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.mwangi.fitnesslog.R
import dev.mwangi.fitnesslog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNav()
    }


    fun setUpBottomNav(){
    binding.bottomNav.setOnItemSelectedListener { item->
    when(item.itemId){
        R.id.plan ->{
           supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
            true
        }
        R.id.track ->{
            supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
            true
        }
        R.id.home ->{
            supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
            true
        }
else->false

    }

}
    }


}
