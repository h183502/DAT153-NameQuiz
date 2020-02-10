package com.example.namequiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_set_name.*

class setNameActivity : AppCompatActivity() {

    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_name)

        val sharedPreferences = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)

        savePrefBtn.setOnClickListener{

            val name = prefName.text.toString().trim()
            val msg = "The preference name is now ${name}"
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

            val editor = sharedPreferences.edit()

            editor.putString("NAME", name)
            editor.apply()
            prefName.setText("")
        }

        showPrefBtn.setOnClickListener{

            val name = sharedPreferences.getString("NAME", "")

            infoPref.text = "Preference name: $name"
            goBack.visibility = View.VISIBLE
            showPrefBtn.visibility = View.INVISIBLE
            savePrefBtn.visibility = View.INVISIBLE
            prefName.visibility = View.INVISIBLE
            infoPref.visibility = View.VISIBLE


        }

        backToMenu.setOnClickListener{
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }

        revealBtn.setOnClickListener{
            revealBtn.visibility = View.INVISIBLE
            prefName.visibility = View.VISIBLE
            savePrefBtn.visibility = View.VISIBLE
            showPrefBtn.visibility = View.VISIBLE
            infoPref.visibility = View.INVISIBLE
            backToMenu.visibility = View.INVISIBLE
            goBack.visibility = View.VISIBLE
        }

        goBack.setOnClickListener{
            revealBtn.visibility = View.VISIBLE
            prefName.visibility = View.INVISIBLE
            savePrefBtn.visibility = View.INVISIBLE
            showPrefBtn.visibility = View.INVISIBLE
            infoPref.visibility = View.INVISIBLE
            goBack.visibility = View.INVISIBLE
            backToMenu.visibility = View.VISIBLE

        }
    }


}