package com.example.core.base

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

abstract class BaseFragmentActivity : FragmentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}