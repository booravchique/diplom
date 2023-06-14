package com.example.diplom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.adapter.MarksNewAdapter
import com.example.diplom.databinding.FragmentMarksBinding
import com.example.diplom.model.Marks
import com.example.diplom.model.MarksInfo
import kotlinx.android.synthetic.main.marks_by_class_layout.view.*


class MarksFragment : Fragment() {

    lateinit var ra: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_marks, container, false)

        ra = root.findViewById(R.id.rv_marks)
        ra.adapter = MarksNewAdapter(requireContext(), MarksInfo().list)
        return root
    }
}