package com.example.pickme2

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.snackbar.Snackbar

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_origin.*
import kotlinx.android.synthetic.main.app_bar_origin.*

class Origin : AppCompatActivity() {

    lateinit var toogle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_origin)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        toogle = ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close);
        drawer_layout.addDrawerListener(toogle)
        toogle.syncState()
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {

            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
//                toogle.onOptionsItemSelected(item)
                drawer_layout.openDrawer(Gravity.LEFT)
            }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.origin, menu)
        return true
    }

}
