package com.example.diplom

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

import com.example.diplom.database.ProfInfo
import com.example.diplom.database.RoomDBProfile
import com.example.diplom.database.RoomDBProfile.Companion.getDBProfile
import com.example.diplom.databinding.ActivityRegBinding

class RegActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegBinding
    var preff: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = RoomDBProfile.getDBProfile(this)

        preff = getSharedPreferences("userId", MODE_PRIVATE)
        var phone: String

        //Получение информации из полей
        binding.loginBtn.setOnClickListener {
            val personIn = ProfInfo(
                null,
                binding.personName.text.toString().filter { !it.isWhitespace() },
                binding.personSurname.text.toString().filter { !it.isWhitespace() },
                binding.personMiddleName.text.toString().filter { !it.isWhitespace() },
                binding.personCollege.text.toString().filter { !it.isWhitespace() },
                binding.personGroup.text.toString().filter { !it.isWhitespace() },
                binding.personNumber.text.toString().filter { !it.isWhitespace() },
                binding.personPassword.text.toString().filter { !it.isWhitespace() },
            )


            //ввод информации в базу данных
            if(binding.personPassword.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty() || binding.personNumber.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty() || binding.personGroup.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty() ||
                binding.personCollege.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty() || binding.personMiddleName.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty() || binding.personMiddleName.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty()||
                binding.personName.text.toString().filter { !it.isWhitespace() }.isNullOrEmpty()){
                val t = Toast.makeText(this, "У Вас есть незаполненные поля", Toast.LENGTH_SHORT)
                t.show()
            } else {
                phone =  binding.personNumber.text.toString()
                Thread {
                    db.getDao().insertItem(personIn)
                }.start()
                val editor = preff?.edit()
                editor?.putString("key1", phone)
                editor?.apply()
                //переход на главную страницу
                val i = Intent(this@RegActivity, MainActivity::class.java)
                startActivity(i)
            }

        }
        //переход назад
        binding.backBtn.setOnClickListener {

            val back = Intent(this@RegActivity, LogInActivity::class.java)
            startActivity(back)
            finish()
        }
    }
}