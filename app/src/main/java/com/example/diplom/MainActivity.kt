package com.example.diplom

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.diplom.databinding.ActivityLogInBinding
import com.example.diplom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var preff: SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ScheludeFragment())
        preff = getSharedPreferences("userId", MODE_PRIVATE)

        //Код выбора нужного фрагмента
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.schelude -> replaceFragment(ScheludeFragment())
                R.id.marks -> replaceFragment(MarksFragment())
                R.id.chat -> replaceFragment(ChatFragment())
                R.id.prepod -> replaceFragment(PrepFragment())
                R.id.profile -> replaceFragment(ProfileFragment())
                else -> {
                }
            }
            true
        }
    }
    //Код перехода между фрагментами
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}



