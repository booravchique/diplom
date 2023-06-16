package com.example.diplom

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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

//    lateinit var binding: FragmentProfileBinding
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("msg", "jhgjghjhgjasd")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_profile, container, false)
//        val view: View = inflater!!.inflate(R.layout.fragment_profile, container, false)
        _binding = FragmentProfileBinding.inflate(inflater,  container,false)


        binding.logout.setOnClickListener {
            val i = Intent(requireContext(), LogInActivity::class.java)
            startActivity(i)
        }

        Log.d("msg", "jhgjghjh7567gjasd")

        Log.d("msg", "a3333sd")
        val db = RoomDBProfile.getDBProfile(requireContext())
        GlobalScope.launch {
//            db.getDao().getLastItem().asLiveData().observe(viewLifecycleOwner) {
//                val info = it[0].name
//                binding.personName.text = info
//                Log.d("msg", "${info}")
//                Log.d("msg", "asd")
//            }
            fromDB()
        }


//        return view
        return binding.root
    }

    suspend fun fromDB() {
        val db = RoomDBProfile.getDBProfile(requireContext())
        lateinit var info: ProfInfo
//        db.getDao().getLastItem().asLiveData().observe(viewLifecycleOwner) {
//            val info = it[0].name
//            binding.personName.text = info
//            Log.d("msg", "${info}")
//            Log.d("msg", "asd")
//        }
        GlobalScope.launch {
            info = db.getDao().getLastItem()
            displayData(info)
        }
    }

    private suspend fun displayData(info: ProfInfo) {
        withContext(Dispatchers.Main){
            binding.personName.text = info.name
            binding.personSurname.text = info.surname
            binding.personNumber.text = info.Number
            binding.personGroup.text = info.group
            binding.personCollege.text = info.collage
        }
    }

}
