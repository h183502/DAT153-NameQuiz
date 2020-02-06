package com.example.namequiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        revealBtn.setOnClickListener{
            revealBtn.visibility = View.INVISIBLE
            prefName.visibility = View.VISIBLE
            savePrefBtn.visibility = View.VISIBLE
            showPrefBtn.visibility = View.VISIBLE
            infoPref.visibility = View.INVISIBLE
        }

        goBack.setOnClickListener{
            revealBtn.visibility = View.VISIBLE
            prefName.visibility = View.INVISIBLE
            savePrefBtn.visibility = View.INVISIBLE
            showPrefBtn.visibility = View.INVISIBLE
            infoPref.visibility = View.INVISIBLE
            goBack.visibility = View.INVISIBLE

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.settings){
            Intent(this, SettingsActivity::class.java).also {
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    public fun onClickDatabase(view: View){
        val database = Intent(this, DbActivity::class.java)

        startActivity(database)
    }

    public fun onClickAdd(view: View){
        val addActivity = Intent(this, AddActivity::class.java)

        startActivity(addActivity)
    }

    public fun onClickQuiz(view: View){
        val quiz = Intent(this, quizActivity::class.java)

        startActivity(quiz)
    }
}
