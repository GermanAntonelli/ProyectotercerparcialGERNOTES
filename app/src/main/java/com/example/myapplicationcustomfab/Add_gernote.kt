package com.example.myapplicationcustomfab

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_gernote.*

class Add_gernote : AppCompatActivity() {

    var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_gernote)

        try {
            var bundle: Bundle = intent.extras
            id = bundle.getInt("MainActId", 0)
            if (id != 0) {
                Edit_text_titulo.setText(bundle.getString("Title"))
                edittext_descripcion.setText(bundle.getString("Content"))
            }
        } catch (ex: Exception) {
        }

        button_agregar.setOnClickListener {
            var dbManager = GernoteDbManager(this)

            var values = ContentValues()
            values.put("Title", Edit_text_titulo.text.toString())
            values.put("Content", edittext_descripcion.text.toString())

            if (id == 0) {
                val mID = dbManager.insert(values)

                if (mID > 0) {
                    Toast.makeText(this, "Nota Agregada Satisfactoriamente", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this, "Error al agregar la Nota", Toast.LENGTH_LONG).show()
                }
            } else {
                var selectionArs = arrayOf(id.toString())
                val mID = dbManager.update(values, "Id=?", selectionArs)

                if (mID > 0) {
                    Toast.makeText(this, "Nota Agregada Satisfactoriamente", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this, "Error al agregar la Nota", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}
