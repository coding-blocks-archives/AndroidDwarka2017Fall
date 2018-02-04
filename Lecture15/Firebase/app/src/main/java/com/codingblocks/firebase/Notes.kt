package com.codingblocks.firebase

class Notes(val id: String, val title: String, val desc: String, val isDone: Boolean) {
    constructor() : this("", "", "", false)
}