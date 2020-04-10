package com.example.pickme2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var databaseRef: DatabaseReference
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        firebaseAuth = FirebaseAuth.getInstance()
        databaseRef = FirebaseDatabase.getInstance().reference
        sharedPreferences = getSharedPreferences("com.example.pickme2", 0)
        //checkExistingUser()
        val loginBtn = findViewById<Button>(R.id.login_btn)
        loginBtn.setOnClickListener() {

            //database connectivity code

            login()
        }
    }
        override fun onStart() {
            super.onStart()

        }
         fun login() {

            val email=email_txt.text.toString().trim()
            val pass=login_password.text.toString().trim()
            if(email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener {
                    var i = Intent(this, GridView::class.java)
                    startActivity(i)

                }.addOnFailureListener{
                    Toast.makeText(
                        applicationContext,
                        "Please Check Your Credentials & Try Again!",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
            else{
                Toast.makeText(applicationContext, "Please Fill The Details", Toast.LENGTH_SHORT).show()

            }
        }

    }



