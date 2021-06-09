package com.cetis108.semana11

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class ContactActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact2)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val contacto = intent.getSerializableExtra("contacto") as Contact
        mostrarMensaje(contacto.print())
    }

    fun mostrarMensaje(msg: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(msg)
            .setCancelable(false)
            .setPositiveButton("OK", DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = builder.create()
        alert.setTitle("Mensaje")
        alert.show()
    }
}