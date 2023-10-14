package com.example.uts1p3b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.uts1p3b.databinding.ActivityDashboardBinding
import com.example.uts1p3b.databinding.ActivityFormBinding

class Form : AppCompatActivity() {
    private lateinit var binding: ActivityFormBinding

    private var hargaTiketSementara = 0
    private var totalHarga = 0
    private var boolPaket1 = false
    private var boolPaket2 = false
    private var boolPaket3 = false
    private var boolPaket4 = false
    private var boolPaket5 = false
    private var boolPaket6 = false
    private var boolPaket7 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFormBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){

            editTextTanggal.setOnClickListener{
                val datePickerDialog = DatePicker()
                datePickerDialog.show(supportFragmentManager, "date picker")
            }

            val stasiun = resources.getStringArray(R.array.stasiun)
            spinnerAsal.adapter = ArrayAdapter<String> (
                this@Form,
                android.R.layout.simple_spinner_item,
                stasiun
            )

            spinnerTujuan.adapter = ArrayAdapter<String> (
                this@Form,
                android.R.layout.simple_spinner_item,
                stasiun
            )

            val kelas = resources.getStringArray(R.array.kelas)
            spinnerClass.adapter = ArrayAdapter<String> (
                this@Form,
                android.R.layout.simple_spinner_item,
                kelas
            )
            spinnerClass.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        when(position) {
                            0 -> {
                                totalHarga = 0
                                txtHarga2.text = "Rp${totalHarga}"
                            }
                            1 -> {
                                totalHarga = 150000 + hargaTiketSementara
                                txtHarga2.text = "Rp${totalHarga}"
                            }
                            2 -> {
                                totalHarga = 50000 + hargaTiketSementara
                                txtHarga2.text = "Rp${totalHarga}"
                            }
                            3 -> {
                                totalHarga = 0 + hargaTiketSementara
                                txtHarga2.text = "Rp${totalHarga}"
                            }

                        }

                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        //TODO: Do something

                    }
                }

            //paket
            toggleSwitch.setOnClickListener{
                if (toggleSwitch.isChecked){
                    totalHarga += 30000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket1 = true
                }
                else {
                    totalHarga -= 30000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket1 = false
                }
            }

            toggleSwitch2.setOnClickListener{
                if (toggleSwitch2.isChecked){
                    totalHarga += 25000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket2 = true
                }
                else {
                    totalHarga -= 25000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket2 = false
                }
            }

            toggleSwitch3.setOnClickListener{
                if (toggleSwitch3.isChecked){
                    totalHarga += 10000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket3 = true
                }
                else {
                    totalHarga -= 10000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket3 = false
                }
            }

            toggleSwitch4.setOnClickListener{
                if (toggleSwitch4.isChecked){
                    totalHarga += 55000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket4 = true
                }
                else {
                    totalHarga -= 55000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket4 = false
                }
            }

            toggleSwitch5.setOnClickListener{
                if (toggleSwitch5.isChecked){
                    totalHarga += 35000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket5 = true
                }
                else {
                    totalHarga -= 35000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket5 = false
                }
            }

            toggleSwitch6.setOnClickListener{
                if (toggleSwitch6.isChecked){
                    totalHarga += 30000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket6 = true
                }
                else {
                    totalHarga -= 30000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket6 = false
                }
            }

            toggleSwitch7.setOnClickListener{
                if (toggleSwitch7.isChecked){
                    totalHarga += 15000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket7 = true
                }
                else {
                    totalHarga -= 15000
                    txtHarga2.text = "Rp${totalHarga}"
                    boolPaket7 = false
                }
            }

            btnPesan.setOnClickListener() {
                val intentToDashboard = Intent(this@Form, Dashboard::class.java)
                startActivity(intentToDashboard)
            }
        }
    }
}