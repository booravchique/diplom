package com.example.diplom

import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = RoomDBProfile.getDBProfile(this)

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

            //проверка на пустые поля
            var isEmpty: Boolean

            if(binding.personName.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }
            if(binding.personSurname.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }
            if(binding.personMiddleName.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }
            if(binding.personCollege.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }
            if(binding.personGroup.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }
            if(binding.personNumber.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }
            if(binding.personPassword.text.toString().isNullOrEmpty()) {
                isEmpty = true
            } else {
                isEmpty = false
            }

            //ввод информации в базу данных
            if(isEmpty){
                val t = Toast.makeText(this, "У Вас есть незаполненные поля", Toast.LENGTH_SHORT)
                t.show()
            } else {
                Thread {
                    db.getDao().insertItem(personIn)
                }.start()
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