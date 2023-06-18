package com.example.diplom

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.diplom.database.ProfInfo
import com.example.diplom.database.RoomDBProfile
import com.example.diplom.databinding.ActivityLogInBinding
import kotlinx.coroutines.*

class LogInActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityLogInBinding
    var preff: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        preff = getSharedPreferences("userId", MODE_PRIVATE)

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

        bindingClass.loginBtn.setOnClickListener {
            GlobalScope.launch {
                LogInBtn()
            }.start()

        }
    }

    private suspend fun LogInBtn() {
        val phoneNumber = bindingClass.personNumber.text.toString().filter { !it.isWhitespace() }
        if (phoneNumber.isNotEmpty()) {
            val db = RoomDBProfile.getDBProfile(this@LogInActivity)
            GlobalScope.launch {
                val info: ProfInfo?
                info = db.getDao().getPasswordByNumber(phoneNumber)

                info?.let {
                    Log.d("asd", "${info.Number}  vefff")
                    if (info.Password.isNotEmpty() && info.Number.isNotEmpty()) {
                        Log.d("asd", "${info.Password} and ${info.Number}")
                        compareData(info)
                    } else {
                        val t = Toast.makeText(
                            this@LogInActivity,
                            "not found error",
                            Toast.LENGTH_SHORT
                        )
                        t.show()
                        Log.d("asd", "${info.Password} and ${info.Number} 123123")
                    }
                }
            }
        } else {
            Log.d("asd", "${phoneNumber}  пустое")
            val t = Toast.makeText(this@LogInActivity, "Введите номер телефона", Toast.LENGTH_SHORT)
            t.show()
        }
    }

    private suspend fun compareData(info: ProfInfo) {
        val enterPhone = bindingClass.personNumber.text.toString().filter { !it.isWhitespace() }
        val enterPassword =
            bindingClass.personPassword.text.toString().filter { !it.isWhitespace() }
        withContext(Dispatchers.Main) {
            if (enterPhone.isNotEmpty() && enterPassword.isNotEmpty()) {
                if (enterPassword == info.Password && enterPhone == info.Number) {
                    val i = Intent(this@LogInActivity, MainActivity::class.java)
                    startActivity(i)
                    val t = Toast.makeText(this@LogInActivity, "Успешно", Toast.LENGTH_SHORT)
                    t.show()
                    val editor = preff?.edit()
                    editor?.putString("key1", info.Number)
                    editor?.apply()
                    finish()
                } else {
                    val t = Toast.makeText(
                        this@LogInActivity,
                        "Логин и пароль не совпадают",
                        Toast.LENGTH_SHORT
                    )
                    t.show()
                }
            } else {
                val t = Toast.makeText(this@LogInActivity, "not found error", Toast.LENGTH_SHORT)
                t.show()
            }
        }
    }
}


