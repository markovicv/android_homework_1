package com.example.rma_h1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rma_h1.Konstants
import com.example.rma_h1.R
import com.example.rma_h1.model.User
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class HomeActivity :AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val user:User = this.intent.getParcelableExtra(Konstants.USER) as User
        var favorite = false

        welcomeTvId.setText("Welcome ${user.username} here is the daily article")

        favoriteId.setOnClickListener {
            if(!favorite){
                favorite=true
                starIv.setImageResource(R.drawable.ic_star_full)
                favoriteId.setText(R.string.btn_unfavorite)

            }
            else{
                favorite=false
                starIv.setImageResource(R.drawable.ic_star_empty)
                favoriteId.setText(R.string.btn_favorite)

            }

        }
        logoutId.setOnClickListener {
            val editor = getSharedPreferences(packageName, Context.MODE_PRIVATE).edit()
            editor.clear().apply()
            startActivity(Intent(this,LoginActivity::class.java))
            this.finish()
        }





    }
}