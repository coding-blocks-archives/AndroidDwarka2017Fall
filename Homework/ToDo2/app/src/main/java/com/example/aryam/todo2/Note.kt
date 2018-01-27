package com.example.aryam.todo2

/**
 * Created by aryam on 1/6/2018.
 */
data class Note(var title : String,var description : String,var isDone : Boolean){
    constructor(title:String,description: String) : this(title,description,false)
}