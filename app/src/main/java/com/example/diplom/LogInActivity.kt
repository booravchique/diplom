package com.example.diplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diplom.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

            //Переход на страницу восстановления пароля
        bindingClass.forgotPassword.setOnClickListener {
            val i = Intent(this@LogInActivity, RecoverPswrd::class.java)
            startActivity(i)
        }

            //Переход на экран регистрации
        bindingClass.regBtn.setOnClickListener {
            val i = Intent(this@LogInActivity, RegActivity::class.java)
            startActivity(i)
        }

        val phone = bindingClass.personNumber.text
        val password = bindingClass.personPassword.text

        bindingClass.loginBtn.setOnClickListener {
//            if (phone.toString() == "+78001231234" && password.toString() == "admin") {}
                val i = Intent(this@LogInActivity, MainActivity::class.java)
                startActivity(i)

        }
    }
}