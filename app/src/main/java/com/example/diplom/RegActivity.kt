package com.example.diplom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding.loginBtn.setOnClickListener {
            val personIn = ProfInfo(
                null,
                binding.personName.text.toString(),
                binding.personSurname.text.toString(),
                binding.personMiddleName.text.toString(),
                binding.personCollege.text.toString(),
                binding.personGroup.text.toString(),
                binding.personNumber.text.toString(),
                binding.personPassword.text.toString(),
            )
            Thread{
                db.getDao().insertItem(personIn)
            }.start()

            val i = Intent(this@RegActivity, MainActivity::class.java)
            startActivity(i)
        }
    }
}