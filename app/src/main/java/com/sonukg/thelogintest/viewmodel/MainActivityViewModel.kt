package com.sonukg.thelogintest.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.sonukg.thelogintest.`interface`.LoginResultCallbacks
import com.sonukg.thelogintest.model.UserModel

class MainActivityViewModel(private val listeners: LoginResultCallbacks):ViewModel() {
    private val userModel:UserModel

    init {
        this.userModel=UserModel("", "", "")
    }
    val emailTextWatcher:TextWatcher
    get() = object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                userModel.setEmail(s.toString())
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }
    val passwordTextWatcher:TextWatcher
    get() = object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            userModel.setPassword(s.toString())
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }
    val confirmPasswordTextWatcher:TextWatcher
    get() = object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            userModel.setConfirmPassword(s.toString())
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

    fun onLoginClicked(view: View){
        val loginCode:Int=userModel.isDataValid()
        if (loginCode==0)
            listeners.onError("Email must not be null")
        else if (loginCode==1)
            listeners.onError("Enter correct email")
        else if (loginCode==2)
            listeners.onError("Password length must be greater than 6")
        else if (loginCode==3)
            listeners.onError("Confirm password must be match with password")
        else
            listeners.onSuccess("Welcome Login successful")
    }

}