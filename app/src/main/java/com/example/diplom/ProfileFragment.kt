package com.example.diplom

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.constraintlayout.helper.widget.Flow
import androidx.lifecycle.asLiveData
import com.example.diplom.database.ProfInfo
import com.example.diplom.database.RoomDBProfile
import com.example.diplom.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    var preff: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        preff = activity?.getSharedPreferences("userId", MODE_PRIVATE)
        val number = preff?.getString("key1", "not found")
//        val t = Toast.makeText(requireContext(), i, Toast.LENGTH_SHORT)
//        t.show()


        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.logout.setOnClickListener {
            val i = Intent(requireContext(), LogInActivity::class.java)
            startActivity(i)
            activity?.finish()
        }

        GlobalScope.launch {
            fromDB(number)
        }

        return binding.root
    }

    suspend fun fromDB(number: String?) {
        val db = RoomDBProfile.getDBProfile(requireContext())
        lateinit var info: ProfInfo

        if (number.isNullOrEmpty()) {
            val t = Toast.makeText(requireContext(), "unknown error", Toast.LENGTH_SHORT)
            t.show()
        } else {
            GlobalScope.launch {
                info = db.getDao().getInfoByNumber(number)
                displayData(info)
            }
        }

    }

    private suspend fun displayData(info: ProfInfo) {
        withContext(Dispatchers.Main) {
            binding.personName.text = info.name
            binding.personSurname.text = info.surname
            binding.personNumber.text = info.Number
            binding.personGroup.text = info.group
            binding.personCollege.text = info.collage
        }
    }
}
