package com.cetis108.semana11

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDate

class AgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateAge(view: View) {
        val year = findViewById<EditText>(R.id.editTextNumberAgeYear).text.toString()
        if (year.isNullOrEmpty()) {
            Toast.makeText(this, "Debes ingresar el año de nacimiento", Toast.LENGTH_SHORT).show()
        } else {
            val age = LocalDate.now().year - year.toInt()
            Toast.makeText(this, "Tu edad es $age", Toast.LENGTH_SHORT).show()
        }
    }
}