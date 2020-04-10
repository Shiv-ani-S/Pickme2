package com.example.pickme2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class Registration : AppCompatActivity() {

    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    //UI elements
    private var etUserName: EditText?= null
    private var etFirstName: EditText? = null
    private var etLastName: EditText? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var etLocation: EditText? = null
    private var etMobileNo: EditText? = null
    private var btnCreateAccount: Button? = null

    private val TAG = "CreateAccountActivity"
    //global variables
    private var userName:String?= null
    private var firstName: String? = null
    private var lastName: String? = null
    private var email: String? = null
    private var password: String? = null
    private var location: String? = null
    private var mobileNo: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        initialise()
    }
    private fun initialise() {
        etUserName = findViewById<View>(R.id.first_name) as EditText
        etFirstName = findViewById<View>(R.id.first_name) as EditText
        etLastName = findViewById<View>(R.id.last_name) as EditText
        etEmail = findViewById<View>(R.id.email) as EditText
        etPassword = findViewById<View>(R.id.login_password) as EditText
        etLocation = findViewById<View>(R.id.location_txt) as EditText
        etMobileNo = findViewById<View>(R.id.mobile_no) as EditText
        btnCreateAccount = findViewById<View>(R.id.reg_btn) as Button

        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference!!.child("Users")
        mAuth = FirebaseAuth.getInstance()
        btnCreateAccount!!.setOnClickListener { createNewAccount() }


        /*val regBtn = findViewById<Button>(R.id.reg_btn)

        regBtn.setOnClickListener {
            val intent = Intent(this, Sell::class.java)
            startActivity(intent)
            Toast.makeText(this,"Successfully Registered:)",Toast.LENGTH_LONG).show()*/


    }
    private fun createNewAccount() {
        userName = etUserName?.text.toString()
        firstName = etFirstName?.text.toString()
        lastName = etLastName?.text.toString()
        email = etEmail?.text.toString()
        password = etPassword?.text.toString()
        location = etLocation?.text.toString()
        mobileNo = etMobileNo?.text.toString()

        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)
            && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(location) && !TextUtils.isEmpty(mobileNo)) {
        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }

        }
fun createUserWithEmailAndPassword() {
    mAuth!!
        .createUserWithEmailAndPassword(email!!, password!!)
        .addOnCompleteListener(this) { task ->

            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                val userId = mAuth!!.currentUser!!.uid
                //Verify Email
                verifyEmail();
                //update user profile information
                val currentUserDb = mDatabaseReference!!.child(userId)
                currentUserDb.child("firstName").setValue(firstName)
                currentUserDb.child("lastName").setValue(lastName)
                updateUserInfoAndUI()
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(
                    this@Registration, "Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

}
    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@Registration, GridView::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    private fun verifyEmail() {
        val mUser = mAuth!!.currentUser;
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@Registration,
                        "Verification email sent to " + mUser.email,
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.e(TAG, "sendEmailVerification", task.exception)
                    Toast.makeText(this@Registration,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}
