package com.example.diplom.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.R
import com.example.diplom.model.MarksModel
import kotlinx.android.synthetic.main.marks_by_class_layout.view.*

//class MarksAdapter: RecyclerView.Adapter<MarksAdapter.MarksViewHolder>() {
//
//    private var marksList = emptyList<MarksModel>()
//
//    class MarksViewHolder(view: View): RecyclerView.ViewHolder(view)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarksViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.marks_by_class_layout, parent, false)
//        return MarksViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MarksViewHolder, position: Int) {
//        holder.itemView.tv_class_name.text = marksList[position].className
//        holder.itemView.tv_prep_name.text = marksList[position].prepName
//        holder.itemView.marks_sum.text = marksList[position].marksSum
//    }
//
//    override fun getItemCount(): Int {
//        return marksList.size
//    }
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun setMarks(list: List<MarksModel>){
//        marksList = list
//        notifyDataSetChanged()
//    }
//
//}