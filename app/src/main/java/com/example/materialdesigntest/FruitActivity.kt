package com.example.materialdesigntest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.materialdesigntest.databinding.ActivityFruitBinding

class FruitActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFruitBinding

    companion object{
        const val FRUIT_NAME = "fruit_name"
        const val FRUIT_IMAGE_ID = "fruit_image_id"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitBinding.inflate(LayoutInflater.from(this))

        val fruitName = intent.getStringExtra(FRUIT_NAME)?:""
        val fruitImageId = intent.getIntExtra(FRUIT_IMAGE_ID,0)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.title = fruitName
        Glide.with(this).load(fruitImageId).into(binding.fruitImageView)
        binding.fruitContent.text = generateFruitContent(fruitName)

        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home->{
                finish()
                return true
            }


        }
        return super.onOptionsItemSelected(item)
    }

    private fun generateFruitContent(fruitName: String) = fruitName.repeat(50)
}