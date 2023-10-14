package com.example.uts1p3b

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.uts1p3b.databinding.ActivityLoginPageBinding
import com.example.uts1p3b.databinding.ActivityMainBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        _ ->
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
            val password = intent.getStringExtra(MainActivity.EXTRA_PASSWORD)

            btnLogin.setOnClickListener {
                if (editTextUsername.text.toString().isEmpty()){
                    editTextUsername.error = "Masukkan Username"
                    return@setOnClickListener
                }
                if (editTextPassword.text.toString().isEmpty()){
                    editTextPassword.error = "Masukkan Password"
                    return@setOnClickListener
                }

                //validasi
                if (editTextUsername.text.toString() == username) {
                    if (editTextPassword.text.toString() == password) {
                        //login berhasil
                        val intentToDashboard = Intent(this@LoginPage, Dashboard::class.java)
                        intentToDashboard.putExtra(MainActivity.EXTRA_USERNAME, username)
                        setResult(Activity.RESULT_OK, intentToDashboard)

                        //clear form
                        editTextUsername.text.clear()
                        editTextPassword.text.clear()

                        launcher.launch(intentToDashboard)
                    }
                    else {
                        Toast.makeText(this@LoginPage, "Password salah", Toast.LENGTH_SHORT).show()
                    }
                }
                else {
                    Toast.makeText(this@LoginPage, "Username salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun goToMainActivity(view: View){
        finish()
    }
}