package com.cetis108.semana11

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class SmsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun sendMessage(view: View) {
        val smsNumber = findViewById<EditText>(R.id.editTextSmsPhoneNumber).text.toString()
        val smsBody = findViewById<EditText>(R.id.editTextSmsBody).text.toString()

        if (smsNumber.isNullOrEmpty() || smsBody.isNullOrEmpty()) {
            Toast.makeText(this, "Debes ingresar el número y el mensaje", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("sms:$smsNumber")
                putExtra("sms_body", smsBody)
            }

            try {
                startActivity(intent)
            } catch (ex: Exception) {
                ex.printStackTrace()
                Toast.makeText(this, "Error: ${ex.toString()}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}