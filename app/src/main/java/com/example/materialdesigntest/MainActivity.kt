package com.example.materialdesigntest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.materialdesigntest.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding

    val fruits = mutableListOf(Fruit("watermelen",R.drawable.watermelon),
        Fruit("lemon",R.drawable.lemon), Fruit("avocado",R.drawable.avocado),
        Fruit("cherry",R.drawable.cherry),Fruit("orange",R.drawable.orange),
        Fruit("pineapple",R.drawable.pineapple),Fruit("strawberry",R.drawable.strawberry)
    )

    val fruitList = ArrayList<Fruit>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)


        setSupportActionBar(binding.toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.mipmap.menu)
        }

        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(Gravity.LEFT)
        }

        binding.navigationView.setNavigationItemSelectedListener {
            binding.drawerLayout.closeDrawers()
            true
        }

        binding.floatButton.setOnClickListener {

            view ->  Snackbar.make(view,"Data deleted",Snackbar.LENGTH_SHORT)
                .setAction("Undo"){
                    Toast.makeText(this,"Data restored",Toast.LENGTH_SHORT).show()
                }.show()

        }

        initRecyclerviewData()

        setContentView(binding.root)
    }

    private fun initRecyclerviewData() {
        fruitList.clear()
        repeat(20){
            val index = ( 0 until fruits.size).random()
            fruitList.add(fruits[index])
        }


        binding.recyclerview.adapter = FruitAdapter(this,fruitList)
        binding.recyclerview.layoutManager = GridLayoutManager(this,2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.toolbar,menu)
        return true

    }
}