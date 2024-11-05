package com.example.androidtp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    public fun goToLogin(view: View)
    {
        finish();
    }

    public fun register(view: View) {
        //GarragMoad
        val login = findViewById<EditText>(R.id.txtRegisterName).text.toString()
        //toto
        val password = findViewById<EditText>(R.id.txtRegisterPassword).text.toString()

        val registerData = RegisterData(login, password)
        Api().post<RegisterData>("https://polyhome.lesmoulinsdudev.com/api/users/register",registerData, ::registerSuccess)
    }

    public fun registerSuccess(responseCode: Int) {
        if (responseCode == 200) {
            finish()
        }
    }
}