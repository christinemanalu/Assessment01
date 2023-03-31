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

        val jumlahmakanan1 = binding.jumlahhoneygarlicchickenrice.text
        val jumlahmakanan2 = binding.jumlahbeefburger.text
        val jumlahmakanan3 = binding.jumlahregulerfries.text

        val jumlahminuman1 = binding.jumlahfantafloat.text
        val jumlahminuman2 = binding.jumlahflurryoreo.text
        val jumlahminuman3 = binding.jumlahicecreamcone.text

        val hargamakanan1 = 35000
        val hargamakanan2 = 30000
        val hargamakanan3 = 25000

        val hargaminuman1 = 15000
        val hargaminuman2 = 18000
        val hargaminuman3 = 10000

        var text = ""
        var totOrder = 0.0
        var discount = 0

        binding.submit.setOnClickListener {
            if(!makanan1.isChecked && !makanan2.isChecked && !makanan3.isChecked && !minuman1.isChecked && !minuman2.isChecked && !minuman3.isChecked) {
                Toast.makeText(applicationContext,"Silahkan Pilih Makanan dan Minuman", Toast.LENGTH_SHORT).show()
            } else {
                if (makanan1. isChecked) {
                    val hasil = "Honey Garlic Chicken Rice"

                    val jumlahMakanan = jumlahmakanan1.toString().toInt() + jumlahmakanan2.toString().toInt() + jumlahmakanan3.toString().toInt()
                    val jumlahMinuman = jumlahminuman1.toString().toInt() + jumlahminuman2.toString().toInt() + jumlahminuman3.toString().toInt()
                    val jml = jumlahMakanan + jumlahMinuman

                    val cal = jml * hargamakanan1

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("debug1",jml.toString())
                    Log.d("debug2",cal.toString())
                    Log.d("makanan1", totOrder.toString())
                }
                if (makanan2.isChecked) {
                    val hasil = "Beef Burger"

                    val jumlahMakanan = Integer.parseInt(jumlahmakanan1.toString()) + Integer.parseInt(jumlahmakanan2.toString()) + Integer.parseInt(jumlahmakanan3.toString())
                    val jml = jumlahMakanan
                    val cal = jml * hargamakanan2

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("debug1",jml.toString())
                    Log.d("debug2",cal.toString())
                    Log.d("makanan2", totOrder.toString())
                }
                if(makanan3.isChecked) {
                    val hasil = "Reguler Fries"

                    val jumlahMakanan = Integer.parseInt(jumlahmakanan1.toString()) + Integer.parseInt(jumlahmakanan2.toString()) + Integer.parseInt(jumlahmakanan3.toString())
                    var jml = jumlahMakanan
                    val cal = jml * hargamakanan3

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("makanan3", totOrder.toString())
                }
                if(minuman1.isChecked) {
                    val hasil = "Fanta Float"
                    val jumlahminuman = Integer.parseInt(jumlahminuman1.toString()) + Integer.parseInt(jumlahminuman2.toString()) + Integer.parseInt(jumlahminuman3.toString())
                    val jml = jumlahminuman
                    val cal = jml * hargaminuman1

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("minuman1", totOrder.toString())
                }

                if(minuman2.isChecked) {
                    val hasil = "Flurry Oreo"
                    val jumlahminuman = Integer.parseInt(jumlahminuman1.toString()) + Integer.parseInt(jumlahminuman2.toString()) + Integer.parseInt(jumlahminuman3.toString())
                    val jml = jumlahminuman
                    val cal = jml * hargaminuman2

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("minuman2", totOrder.toString())
                }

                if(minuman3.isChecked) {
                    val hasil = "Ice Cream Cone"
                    val jumlahminuman = Integer.parseInt(jumlahminuman1.toString()) + Integer.parseInt(jumlahminuman2.toString()) + Integer.parseInt(jumlahminuman3.toString())
                    val jml = jumlahminuman
                    val cal = jml * hargaminuman3

                    text += "$jml \t\t $hasil \t\t\t\t\t\t\t\t\t Rp. $cal \t\t"
                    totOrder += cal
                    Log.d("minuman3", totOrder.toString())
                }
                if (totOrder > 100000) {
                    discount = 10000
                }

                var total = totOrder - discount
                Log.d("CEKKEKE",discount.toString())
                startActivity(
                    Intent(this, MainActivity2::class.java)
                        .putExtra("Coba", text)
                        .putExtra("Bayar", total)
                        .putExtra("Diskon", discount)
                )
            }

        }

    }
}
