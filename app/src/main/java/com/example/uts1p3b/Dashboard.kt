package com.example.uts1p3b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.uts1p3b.databinding.ActivityDashboardBinding
import com.example.uts1p3b.databinding.ActivityMainBinding

class Dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    private val listTanggalTrip = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            txtRencanaPerjalanan.setOnClickListener{
                val intentToForm = Intent(this@Dashboard, Form::class.java)
                startActivity(intentToForm)
            }

            binding.calendarView.setOnDateChangeListener() { view,
                                                             year,
                                                             month,
                                                             dayOfMonth ->

                if (listTanggalTrip.contains("$dayOfMonth/${month + 1}/$year")) {
                    Toast.makeText(
                        this@Dashboard,
                        "Anda telah melakukan pemesanan pada $dayOfMonth/${month + 1}/$year",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this@Dashboard,
                        "Tidak ada riwayat perjalanan anda",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}