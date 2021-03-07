package com.example.kotlincalculator

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

//setar controles- https://developer.android.com/guide/topics/ui/declaring-layout?hl=pt-br
//botoes - https://developer.android.com/guide/topics/ui/controls/button?hl=pt-br#kotlin
//events - https://developer.android.com/guide/topics/ui/ui-events?hl=pt-br

//faltou dar atenção aos gets e sets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val n1: TextView = this.findViewById(R.id.editTextNumber)
        val n2: TextView = this.findViewById(R.id.editTextNumber1)

        /* PROBLEMA: Conversão textview para float
        val n1S: String = n1.text.toString()
        val n2S: String = n2.text.toString()
        val n1f: Float = n1S.toDouble()
        val n2f: Float = n2S.toFloat()*/

        val buttomSum: Button = findViewById(R.id.buttonSum)
        /*val buttomSubtraction: Button = this.findViewById(R.id.buttonSubtraction)
        val buttomMultiplication: Button = findViewById(R.id.buttonMultiplication)
        val buttomDivision: Button = findViewById(R.id.buttonDivision)*/

        val result: TextView = findViewById(R.id.editTextResult)
        var aux:Float

        //chamadas para as funções de ordem superior
        /*var soma:Float = calculate(n1, n2){a,b -> a+b}
        var subtracao:Float = calculate(n1, n2){a,b -> a-b}
        var multiplicacao:Float = calculate(n1, n2){a,b -> a*b}
        var divisao:Float = calculate(n1, n2){a,b -> a/b}*/

        buttomSum.setOnClickListener{
            aux = calculate(n1, n2){a,b -> a+b} //n1 e n2 precisam ser convertidos para float
            result.text = aux.toString()
        }
        /*
        val onClickListener = buttomSubtraction.setOn
        fun calculadora(n1:Float?, n2:Float?, tipo:Int){
            if(n1 != null && n2 != null) {
                println("Tudo certo, continuando a operação")



                when(tipo){
                    1 ->
                    2 -> display(n1, n2, "Subtração", subtracao)
                    3 -> display(n1, n2, "Multiplicação", multiplicacao)
                    4 -> display(n1, n2, "Divisão", divisao)
                    else -> println("Valor inserido inválido!")
                }
            } else {
                println("Não é aceito valores nulos!")
            }*/
        }
    }


    fun calculate(n1:Float, n2:Float, operation:(Float, Float)->Float):Float{
        return operation(n1, n2)
    }



/*
private fun display(n1:Float, n2:Float, operation:String, result:Float?){
    val result = findViewById(R.id.editTextResult)
    result.setText(result)
}

*/