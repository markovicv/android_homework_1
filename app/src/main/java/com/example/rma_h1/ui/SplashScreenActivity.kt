package com.example.rma_h1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.rma_h1.Konstants
import com.example.rma_h1.R
import com.example.rma_h1.model.User
import kotlinx.android.synthetic.main.activity_splas_screen.*

class SplashScreenActivity :AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splas_screen);

        Glide.with(this)
            .load("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fsecurecdn.pymnts.com%2Fwp-content%2Fuploads%2F2016%2F09%2FUnder-Armor-New-President.jpg&f=1&nofb=1")
            .centerCrop()
            .into(splash_image_id)


        val sharedPrefernce = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        var isLogged = true

        val username = sharedPrefernce.getString("username",null)
        val password = sharedPrefernce.getString("password",null)

        if(username==null || password==null) {
            isLogged = false
        }

        Handler().postDelayed({
            lateinit var intent :Intent
            if(isLogged){
                val user = User(username,password)
                intent = Intent(this,HomeActivity::class.java)
                intent.putExtra(Konstants.USER, user)
            }
            else{
                intent = Intent(this,LoginActivity::class.java)
            }
            startActivity(intent)
            finish()
        },5000)




    }
}