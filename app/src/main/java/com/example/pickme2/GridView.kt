package com.example.pickme2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GridView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view2)

        val afterReg = findViewById<Button>(R.id.add_list)

        afterReg.setOnClickListener {
            val intent = Intent(this, Origin::class.java)
            startActivity(intent)

        }

    }}

