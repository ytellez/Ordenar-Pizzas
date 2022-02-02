package com.tecnasa.appordenarpizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var smallPizza: RadioButton
    private lateinit var mediumPizza: RadioButton
    private lateinit var largePizza: RadioButton

    private lateinit var onionCheckBox: CheckBox
    private lateinit var olivesCheckBox: CheckBox
    private lateinit var tomatoesCheckBox: CheckBox

    private lateinit var res: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        smallPizza = findViewById(R.id.smallpizza)
        mediumPizza = findViewById(R.id.mediumpizza)
        largePizza = findViewById(R.id.largepizza)

        onionCheckBox = findViewById(R.id.OnionsCheckBox)
        olivesCheckBox = findViewById(R.id.OlivesCheckBox)
        tomatoesCheckBox = findViewById(R.id.TomatoeCheckBox)

        res = findViewById(R.id.totalPrice)
    }

    fun onPlaceOrderButtonClicked(view: View) {
        var pizzaSizePrice = 0.0
        var toppingsTotal = 0.0

        if (!smallPizza.isChecked && !mediumPizza.isChecked && !largePizza.isChecked)
            Toast.makeText(this, "Debe seleccionar alguna de las opciones", Toast.LENGTH_SHORT)
                .show()
        else if (!onionCheckBox.isChecked && !olivesCheckBox.isChecked && !tomatoesCheckBox.isChecked)
            Toast.makeText(this, "Debe seleccionar alguna de las opciones", Toast.LENGTH_SHORT)
                .show()
        else {

            when {
                smallPizza.isChecked -> pizzaSizePrice = 5.0
                mediumPizza.isChecked -> pizzaSizePrice = 7.0
                largePizza.isChecked -> pizzaSizePrice = 9.0
            }

            if (onionCheckBox.isChecked) toppingsTotal += 1
            if (olivesCheckBox.isChecked) toppingsTotal += 2
            if (tomatoesCheckBox.isChecked) toppingsTotal += 3

            res.text = "TOTAL ORDER PRICE ${pizzaSizePrice + toppingsTotal}"
        }
    }
}