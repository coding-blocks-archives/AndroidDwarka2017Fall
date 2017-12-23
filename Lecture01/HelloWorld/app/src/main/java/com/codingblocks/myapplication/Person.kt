package com.codingblocks.myapplication

/**
 * Created by harshit on 23/12/17.
 */

val HELLO : String = "Hello"

open class Person(open val name : String = "", open val age : Int = 0, open val address : String = ""){


    fun hello() : String {
        return name
    }

    fun helloWorld() : String = name

}

data class Teacher(override var name: String, override var age: Int, override var address: String, val subject : String) :
        Person(name, age, address) {



}