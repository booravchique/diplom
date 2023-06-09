package com.example.diplom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.adapter.MarksAdapter
import com.example.diplom.databinding.ActivityMainBinding
import com.example.diplom.databinding.FragmentMarksBinding
import com.example.diplom.model.MarksModel


class MarksFragment : Fragment() {

    lateinit var binding: FragmentMarksBinding
    lateinit var adapter: MarksAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initial()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marks, container, false)
    }

    private fun initial(){
        recyclerView = binding.rvMarks
        adapter = MarksAdapter()
        recyclerView.adapter = adapter
        adapter.setMarks(myMarks())
    }

    fun myMarks(): ArrayList<MarksModel>{
        val marksList = ArrayList<MarksModel>()

        val marks = MarksModel("Дизайн","Иванова А.А.","4,9")
        marksList.add(marks)
        val marks2 = MarksModel("Физика","Иванова А.А.","4,9")
        marksList.add(marks2)
        val marks3 = MarksModel("Химия","Иванова А.А.","4,9")
        marksList.add(marks3)

        return marksList

    }

}