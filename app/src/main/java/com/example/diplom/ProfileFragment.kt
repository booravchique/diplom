package com.example.diplom

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import com.example.diplom.database.ProfInfo
import com.example.diplom.database.RoomDBProfile
import com.example.diplom.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.logout.setOnClickListener {
            val i = Intent(requireContext(), MainActivity::class.java)
            startActivity(i)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
        val db = RoomDBProfile.getDBProfile(requireContext())
        db.getDao().getAllItem().asLiveData().observe(viewLifecycleOwner){ list ->
            list.forEach {
                val info = ProfInfo(it.id, it.middleName, it.surname, it.name, it.studyAt, it.group, it.Birthday, it.Email)
                binding.personName.append(info.name)
                binding.personSurname.append(it.surname)
            }
        }
    }
}