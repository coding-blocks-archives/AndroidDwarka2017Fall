package com.codingblocks.githubapp

/**
 * Created by harshit on 14/01/18.
 */
class PokemonResponse(val forms: ArrayList<Form>, val name: String, val sprites: Sprites,
                      val height: String, val id: Int,
                      val base_experience: Int) {
}

class Form(val url : String, val name : String)

class Sprites(val back_default : String, val front_default : String)