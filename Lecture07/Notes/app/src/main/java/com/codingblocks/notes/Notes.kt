package com.codingblocks.notes

/**
 * Created by harshit on 06/01/18.
 */
data class Notes(val title: String, val description: String, val isDone: Boolean) {

    constructor(title: String) : this(title, "", false)

}