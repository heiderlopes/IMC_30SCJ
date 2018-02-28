package com.example.logonpf.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonpf.imc.extensions.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    fun setaImagem(resourceId: Int) {
        ivStatusIMC.setImageDrawable(
                ContextCompat.getDrawable(this,
                        resourceId))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if(intent.extras != null) {
            val peso = intent.getStringExtra("PESO").toDouble()
            val altura = intent.getStringExtra("ALTURA").toDouble()

            val imc = peso / (altura * altura)

            tvIMC.text = imc.format(1)

            if (imc < 18.5) {
                tvStatusIMC.text = "Abaixo do peso"
                setaImagem(R.drawable.abaixo)
            } else if( imc < 24.9) {
                tvStatusIMC.text = "Peso ideal"
                setaImagem(R.drawable.ideal)
            } else if (imc < 29.9) {
                tvStatusIMC.text = "Levemente acima do peso"
                setaImagem(R.drawable.sobre)
            } else if (imc < 34.9) {
                tvStatusIMC.text = "Obesidade 1"
                setaImagem(R.drawable.obesidade)
            } else if(imc < 39.9) {
                tvStatusIMC.text = "Obesidade 2"
                setaImagem(R.drawable.obesidade)
            } else {
                tvStatusIMC.text = "Obesidade 3"
                setaImagem(R.drawable.obesidade)
            }

            /*when (imc) {
                in 0..18 -> {
                    tvStatusIMC.text = "Abaixo do peso"
                    ivStatusIMC.setImageDrawable(
                            ContextCompat.getDrawable(this,
                                    R.drawable.abaixo)
                    )
                }

            }*/
        }
    }
}
