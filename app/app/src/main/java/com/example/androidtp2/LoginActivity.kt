package com.example.androidtp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    public fun registerNewAccount(view: View)
    {
        val intent = Intent(this, RegisterActivity::class.java);
        startActivity(intent);
    }

    public fun login(view: View) {
        val login = findViewById<EditText>(R.id.loginTxt).text.toString()
        val password = findViewById<EditText>(R.id.mdpTxt).text.toString()
        val loginData = LoginData(login, password)
        Api().post<LoginData , String>("https://polyhome.lesmoulinsdudev.com/api/users/auth", loginData, ::loginSuccess)
    }

    public fun loginSuccess(responseCode: Int, token: String?) {
        if (responseCode == 200) {
            val intent = Intent(this, OrdersActivity::class.java)
            intent.putExtra("TOKEN", token)
            startActivity(intent)
        }
    }
}