package com.example.aryam.todo2

/**
 * Created by aryam on 1/6/2018.
 */
data class Note2(val title : String,var isDone : Boolean){
    constructor(title:String) : this(title,false)
}