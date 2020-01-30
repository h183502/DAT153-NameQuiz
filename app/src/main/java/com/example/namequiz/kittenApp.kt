package com.example.namequiz

import android.app.Application
import android.graphics.BitmapFactory

class KittenApp : Application(){
    var data = ArrayList<Kittens>()

    override fun onCreate() {
        super.onCreate()
        data.add(Kittens("Gray", BitmapFactory.decodeResource(resources, R.drawable.kitten1)))
        data.add(Kittens("White", BitmapFactory.decodeResource(resources, R.drawable.kitten2)))
        data.add(Kittens("Brown", BitmapFactory.decodeResource(resources, R.drawable.kitten3)))
    }
}