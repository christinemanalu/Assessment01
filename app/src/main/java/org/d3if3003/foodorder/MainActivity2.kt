package org.d3if3003.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.d3if3003.foodorder.databinding.ActivityMain2Binding
import org.d3if3003.foodorder.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra("Coba")
        val totOrder = intent.getIntExtra("Bayar",500)
        val discount = intent.getDoubleExtra("Discount", 500.0)

        // coba, bayar, diskon
        binding.total.text = text.toString()
        binding.belanja.text = totOrder.toString()
        binding.discount.text = discount.toString()
    }
}