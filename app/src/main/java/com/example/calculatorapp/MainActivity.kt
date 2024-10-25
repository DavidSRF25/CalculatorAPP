package com.example.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    val SUMA = "+"
    val RESTA = "-"
    val MULTIPLICACION = "*"
    val DIVISION = "/"
    val PORCENTAJE = "%"



    //

    var OperacionAc =""

    var  primerNum:Double = Double.NaN
    var secondNum:Double = Double.NaN
    lateinit var  tvTemp:TextView
    lateinit var result:TextView



    lateinit var formatDecimal : DecimalFormat






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
            formatDecimal = DecimalFormat("#.#######")
            tvTemp = findViewById(R.id.tvTemp)
            result = findViewById(R.id.result)


    }

//Funcion cambiar operador del boton
    fun changeOperator(b:View){
        //convertir View a Boton
        val button:Button = b as Button

        if(button.text.toString().trim()=="÷"){

            OperacionAc = "/"
        }else if(button.text.toString().trim()=="*"){

            OperacionAc = "*"

        }else{

            OperacionAc = button.toString().toString().trim()

        }


    }

    fun Calculate(b: View){

        if(Double.NaN!==primerNum){

            secondNum = tvTemp.text.toString().toDouble()
            tvTemp.text=""

            when(OperacionAc){
                "+"-> primerNum = (primerNum+secondNum)
                "-"-> primerNum = (primerNum-secondNum)
                "*"-> primerNum = (primerNum*secondNum)
                "/"-> primerNum = (primerNum/secondNum)
                "%"-> primerNum = (primerNum%secondNum)
            }

        }else{

           primerNum = tvTemp.text.toString().toDouble()


        }


    }

    fun SelectNumber(b: View){

        val boton:Button = b as Button
        if(tvTemp.text.toString()=="0"){

            tvTemp.text=""

        }
        tvTemp.text = tvTemp.text.toString() + boton.text.toString()


    }
}