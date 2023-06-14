package com.example.diplom.model

data class Marks(
    val MarksClassName: String,
    val MarksPrepName: String,
    val MarksMarksSum: String
)
class MarksInfo{
    val list = arrayListOf(
        Marks("Дизайн","Юрченко А.В.","4.9"),
        Marks("Программирование","Андропов М.С.","4.4"),
        Marks("Математика","Петров Г.В.","3.8")
    )
}
