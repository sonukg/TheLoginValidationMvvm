package com.sonukg.thelogintest.`interface`

interface LoginResultCallbacks {
    fun onSuccess(message:String)
    fun onError(message: String)
}