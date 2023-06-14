package com.example.diplom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diplom.R
import com.example.diplom.model.Marks

class MarksNewAdapter (val con: Context, val list:ArrayList<Marks>): RecyclerView.Adapter<MarksNewAdapter.Link>() {
    class Link(itemView: View):RecyclerView.ViewHolder(itemView) {
        val className: TextView = itemView.findViewById(R.id.tv_class_name)
        val prepName: TextView = itemView.findViewById(R.id.tv_prep_name)
        val marksSum: TextView = itemView.findViewById(R.id.marks_sum)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarksNewAdapter.Link {
        val root = LayoutInflater.from(con).inflate(R.layout.marks_by_class_layout,parent,false)
        return Link(root)
    }

    override fun onBindViewHolder(holder: MarksNewAdapter.Link, position: Int) {
        holder.className.setText(list[position].MarksClassName)
        holder.prepName.setText(list[position].MarksPrepName)
        holder.marksSum.setText(list[position].MarksMarksSum)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
