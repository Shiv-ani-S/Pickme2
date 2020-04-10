package com.example.pickme2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AfterSplash : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val logBtn = findViewById<Button>(R.id.main_login_btn)

        logBtn.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        val joinBtn=findViewById<Button>(R.id.main_join_now_btn)

         joinBtn.setOnClickListener{
             val intent1=Intent(this,Registration::class.java)
             startActivity(intent1)

        }
    }
}