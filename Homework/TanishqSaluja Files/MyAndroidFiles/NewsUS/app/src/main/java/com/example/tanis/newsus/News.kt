package com.example.tanis.newsus

/**
 * Created by tanis on 1/19/2018.
 */
data class News(val title:String,val description:String,val photo:String,val more:String)

data class Shoe(val size:Int,val wide:Boolean,val origin:String,val style:InnerShoe)
data class InnerShoe(val categories:ArrayList<Item>,val color:String)
data class Item(val item:String)