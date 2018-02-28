package com.example.logonpf.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcular.setOnClickListener {
            val telaResultado = Intent(this,
                    ResultadoActivity::class.java)

            telaResultado.putExtra("PESO",
                    inputPeso.editText?.text.toString())

            telaResultado.putExtra("ALTURA",
                    inputAltura.editText?.text.toString())

            startActivity(telaResultado)
        }

        btLimpar.setOnClickListener {
            inputAltura.editText?.setText("")
            inputPeso.editText?.setText("")
            inputPeso.requestFocus()
        }
    }
}
