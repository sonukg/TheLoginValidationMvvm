package com.sonukg.thelogintest.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

data class UserModel(
    private var email: String, private var password: String,
    private var confirmPassword: String
):
    BaseObservable(){

    fun isDataValid():Int{
        if (TextUtils.isEmpty(getEmail()))
            return 0
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1
        else if (getPassword().length <7)
            return 2
        else if (!getConfirmPassword().equals(getPassword()))
            return 3
        else return -1

    }
    fun getEmail():String{
        return email
    }

    fun getPassword():String{
        return password
    }

    fun getConfirmPassword():String{
        return confirmPassword
    }

    fun setEmail(email: String){
        this.email=email
    }

    fun setPassword(password: String){
        this.password=password
    }

    fun setConfirmPassword(confirmPassword: String){
        this.confirmPassword=confirmPassword
    }

}