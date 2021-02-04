package com.sonukg.thelogintest.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sonukg.thelogintest.`interface`.LoginResultCallbacks
import com.sonukg.thelogintest.viewmodel.MainActivityViewModel

class LoginViewModelFactory(private val listeners:LoginResultCallbacks):
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(listeners) as T
    }
}