package com.example.aryam.userfetcher

/**
 * Created by aryam on 1/18/2018.
 */
data class SingleUser(val login : String,val avatar_url : String,val name : String,val bio : String,val followers : String,val following : String,val public_repos : String,val html_url : String) : Any()