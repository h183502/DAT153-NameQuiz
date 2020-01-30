package com.example.namequiz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val kittenList: ArrayList<Kittens>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val imageViewName = itemView.findViewById(R.id.imageViewName) as ImageView
        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return kittenList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val kittens: Kittens = kittenList[position]

        holder.imageViewName.setImageBitmap(kittens.image)
        holder.textViewName.text = kittens.name

    }
}