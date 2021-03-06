package com.example.materialdesigntest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FruitAdapter(val context: Context, val fruitList:List<Fruit>) :
    RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val fruitImage : ImageView = view.findViewById(R.id.fruit_photo)
        val fruitName : TextView = view.findViewById(R.id.infoText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitAdapter.ViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitName.text = fruit.fruitName
        Glide.with(context).load(fruit.fruitImageId).into(holder.fruitImage)
    }

    override fun getItemCount() = fruitList.size


}