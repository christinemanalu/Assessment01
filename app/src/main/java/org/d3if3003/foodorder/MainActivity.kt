package org.d3if3003.foodorder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.d3if3003.foodorder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val makanan1 = binding.honeygalicchickenrice
        val makanan2 = binding.beefburger
        val makanan3 = binding.regularfries

        val minuman1 = binding.fantafloat
        val minuman2 = binding.flurryoreo
        val minuman3 = binding.icecreamcone

        val jumlahmakanan1 = binding.jumlahhoneygarlicchickenrice.text.toString()
        val jumlahmakanan2 = binding.jumlahbeefburger.text.toString()
        val jumlahmakanan3 = binding.jumlahregulerfries.text.toString()

        val jumlahminuman1 = binding.jumlahfantafloat.text.toString()
        val jumlahminuman2 = binding.jumlahflurryoreo.text.toString()
        val jumlahminuman3 = binding.jumlahicecreamcone.text.toString()

        val hargamakanan1 = 35.000
        val hargamakanan2 = 30.000
        val hargamakanan3 = 25.000

        val hargaminuman1 = 15.000
        val hargaminuman2 = 18.000
        val hargaminuman3 = 10.000

        var text = ""
        var totOrder = 0.0
        var discount = 0

        binding.submit.setOnClickListener {
            if(!makanan1.isChecked && !makanan2.isChecked && !makanan3.isChecked && !minuman1.isChecked && !minuman2.isChecked && !minuman3.isChecked) {
                Toast.makeText(applicationContext,"Silahkan Pilih Makanan dan Minuman", Toast.LENGTH_SHORT).show()
            } else {
                text = ""
                totOrder = 0.0
                discount = 0
                if (makanan1. isChecked) {
                    val hasil = "Honey Garlic Chicken Rice"

                    val jumlahMakanan = Integer.parseInt(jumlahmakanan1) + Integer.parseInt(jumlahmakanan2) + Integer.parseInt(jumlahmakanan3)
                    val jumlahMinuman = Integer.parseInt(jumlahminuman1) + Integer.parseInt(jumlahminuman2) + Integer.parseInt(jumlahminuman3)
                    val jml = jumlahMakanan + jumlahMinuman

                    val cal = jml * hargamakanan1

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("makanan1", totOrder.toString())
                }
                if (makanan2.isChecked) {
                    val hasil = "Beef Burger"

                    val jumlahMakanan = Integer.parseInt(jumlahmakanan1) + Integer.parseInt(jumlahmakanan2) + Integer.parseInt(jumlahmakanan3)
                    val jml = 0
                    val cal = jml * hargamakanan2

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("makanan2", totOrder.toString())
                }
                if(makanan3.isChecked) {
                    val hasil = "Reguler Fries"

                    val jumlahMakanan = Integer.parseInt(jumlahmakanan1) + Integer.parseInt(jumlahmakanan2) + Integer.parseInt(jumlahmakanan3)
                    var jml = 0
                    val cal = jml * hargamakanan3

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("makanan3", totOrder.toString())
                }
                if(minuman1.isChecked) {
                    val hasil = "Fanta Float"
                    val jumlahminuman = Integer.parseInt(jumlahminuman1) + Integer.parseInt(jumlahminuman2) + Integer.parseInt(jumlahminuman3)
                    val jml = 0
                    val cal = jml * hargaminuman1

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("minuman1", totOrder.toString())
                }
                if(minuman2.isChecked) {
                    val hasil = "Flurry Oreo"
                    val jumlahminuman = Integer.parseInt(jumlahminuman1) + Integer.parseInt(jumlahminuman2) + Integer.parseInt(jumlahminuman3)
                    val jml = 0
                    val cal = jml * hargaminuman2

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("minuman2", totOrder.toString())
                }
                if(minuman3.isChecked) {
                    val hasil = "Ice Cream Cone"
                    val jumlahminumana = Integer.parseInt(jumlahminuman1) + Integer.parseInt(jumlahminuman2) + Integer.parseInt(jumlahminuman3)
                    val jml = 0
                    val cal = jml * hargaminuman3

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("minuman3", totOrder.toString())
                }
                if (totOrder > 100000)
                    discount = 10000
            }
            startActivity(
                Intent(this, MainActivity2::class.java)
                    .putExtra("Coba", text)
                    .putExtra("Bayar", totOrder)
                    .putExtra("Diskon", discount)
            )

        }

    }
}