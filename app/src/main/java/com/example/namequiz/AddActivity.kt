package com.example.namequiz

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.add_activity.*
import kotlinx.android.synthetic.main.list_layout.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.add_activity)
    }

    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_IMAGE_PICK = 2

    fun pickPhoto(view: View){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    fun addKitten(view: View){
        val bitmap: Bitmap = (imageView.drawable as BitmapDrawable).bitmap
        val kitten = Kittens(inputText.text.toString(), bitmap)
        val data = (application as KittenApp).data
        data.add(kitten)
        Toast.makeText(this, "${inputText.text} added to database!", Toast.LENGTH_SHORT).show()
        inputText.setText("")
        imageView.setImageDrawable(null)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_IMAGE_PICK){
            imageView.setImageURI(data?.data)
        }
    }
}
