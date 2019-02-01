package com.coba.project.aplikasimakanan

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_food.*

class MainActivity : AppCompatActivity() {
    val  manager=supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                createFragmentFood()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                createFragmentDrink()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                createFragmentOrder()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFragmentFood()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


    }
    fun createFragmentFood()
    {
        val  transaction=manager.beginTransaction()
        val  fragment=FoodFragment()
        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun createFragmentDrink()
    {
        val  transaction=manager.beginTransaction()
        val  fragment=DrinkFragment()
        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    fun createFragmentOrder()
    {
        val  transaction=manager.beginTransaction()
        val  fragment=OrderFragment()
        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
