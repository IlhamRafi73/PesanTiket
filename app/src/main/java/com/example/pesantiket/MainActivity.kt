package com.example.pesantiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pesantiket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cities: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cities = resources.getStringArray(R.array.cities)
        with(binding){
            val adapterProvinces = ArrayAdapter(this@MainActivity, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cities)
            adapterProvinces.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerDestination.adapter = adapterProvinces

            pesanButton.setOnClickListener{
                val selectedDestination = spinnerDestination.selectedItem.toString()
                val selectedDate = "${datePicker.dayOfMonth}-${datePicker.month + 1}-${datePicker.year}"
                val selectedTime = "${timePicker.hour}:${timePicker.minute}"

                val toastMessage = "Tiket tujuan $selectedDestination tanggal $selectedDate jam $selectedTime berhasil dipesan"
                Toast.makeText(applicationContext, toastMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}