package com.codingblocks.okhttpgson

import com.google.gson.annotations.SerializedName

/**
 * Created by harshit on 20/01/18.
 */

data class Response(val forms: ArrayList<Form>, val abilities: ArrayList<Ability>,
                    val stats : ArrayList<Stat>, val name : String, val weight : Int,
                    val sprites : Sprites, val held_items : ArrayList<HeldItems>,
                    val height : Int, val id : Int, val species : Form, val base_experience : Int,
                    val types: ArrayList<Type>)

data class Form(val url: String, val name: String)

data class Ability(val slot: Int, val is_hidden: Boolean, val ability: Form)

//data class InnerAbility(val url: String, val name: String)

data class Stat(val stat : Form, val effort : Int, val base_stat : Int)

data class Sprites(val back_female : String, @SerializedName("back_default") val backDefault : String,
                   val front_default : String)

data class HeldItems(val item : Form, val version_details :ArrayList<Version>)

data class Version(val version : Form, val rarity : Int)

data class Type(val slot : Int, val type : Form)