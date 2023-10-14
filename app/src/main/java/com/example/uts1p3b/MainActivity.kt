package com.example.uts1p3b

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.example.uts1p3b.databinding.ActivityMainBinding
import java.time.Month
import java.time.Year
import java.util.Calendar

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            
//            val calendarDatePicker = findViewById<DatePicker>(R.id.calendar_date_picker)
            editTextDob.setOnClickListener{
                calendarDatePicker.visibility = View.VISIBLE
                val datePicker = DatePicker()
                datePicker.show(supportFragmentManager, "datePicker")
                }

            btnRegister.setOnClickListener{
                if (editTextEmail.text.toString().isEmpty()){
                    editTextEmail.error = "Masukkan Email"
                    return@setOnClickListener
                }
                if (editTextUsername.text.toString().isEmpty()){
                    editTextUsername.error = "Masukkan Username"
                    return@setOnClickListener
                }
                if (editTextPassword.text.toString().isEmpty()){
                    editTextPassword.error = "Masukkan Password"
                    return@setOnClickListener
                }
                if (editTextDob.text.toString().isEmpty()){
                    editTextDob.error = "Pilih Tanggal Lahir Anda"
                    return@setOnClickListener
                }

                if (editTextDob.text.isNotEmpty()){
                    //mengambil tahun sekarang
                    val currentYear = Calendar.getInstance().get(Calendar.YEAR)

                    //menghitung umur user
                    val dateOfBirth = editTextDob.text.toString()
                    val dateOfBirthSplit = dateOfBirth.split("/")
                    val yearOfBirth = dateOfBirthSplit[2].toInt()
                    val age = currentYear - yearOfBirth

                    //condition
                    if (age < 14) {
                        Toast.makeText(
                            this@MainActivity,
                            "Registrasi gagal, anda belum cukup umur.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else{
                        //masuk ke login page
                        val intentToLoginPage = Intent(this@MainActivity, LoginPage::class.java)

                        intentToLoginPage.putExtra(EXTRA_EMAIL, editTextEmail.text.toString())
                        editTextEmail.setText("")

                        intentToLoginPage.putExtra(EXTRA_USERNAME, editTextUsername.text.toString())
                        editTextUsername.setText("")

                        intentToLoginPage.putExtra(EXTRA_PASSWORD, editTextPassword.text.toString())
                        editTextPassword.setText("")

                        editTextDob.setText("")

                        startActivity(intentToLoginPage)
                    }




                }
            }
        }
    }

    override fun onDateSet(
        view: android.widget.DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth:  Int
    ) {
        val selectedDate = "$dayOfMonth/${month+1}/$year"
        binding.editTextDob.setText(selectedDate)
    }
}