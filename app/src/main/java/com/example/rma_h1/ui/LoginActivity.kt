package com.example.rma_h1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rma_h1.Konstants
import com.example.rma_h1.R
import com.example.rma_h1.model.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtnId.setOnClickListener {
            var username = usernmaeId.text.toString()
            var password = passwordId.text.toString()

            if(username==null || username.equals("") || password==null || password.equals("")){
                Toast.makeText(this,"Niste uspesno logovanje",Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            val editor = getSharedPreferences(packageName, Context.MODE_PRIVATE).edit()

            editor.putString("username",username)
            editor.putString("password",password)
            editor.apply()
            val user = User(username,password)

            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra(Konstants.USER,user)
            startActivity(intent)
            finish()



        }
    }
}