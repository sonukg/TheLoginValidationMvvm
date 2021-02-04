package com.sonukg.thelogintest.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.sonukg.thelogintest.R
import com.sonukg.thelogintest.`interface`.LoginResultCallbacks
import com.sonukg.thelogintest.databinding.ActivityMainBinding
import com.sonukg.thelogintest.viewmodel.MainActivityViewModel
import com.sonukg.thelogintest.viewmodel.factory.LoginViewModelFactory
import java.util.*

class MainActivity : AppCompatActivity(),LoginResultCallbacks {
    private var binding:ActivityMainBinding?=null
    private var mainViewModel:MainActivityViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel=ViewModelProviders.of(this,LoginViewModelFactory(this))
            .get(MainActivityViewModel::class.java)
        binding!!.setLifecycleOwner(this)
        binding!!.viewModel=mainViewModel
        }

    override fun onSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}