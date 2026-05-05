package com.example.lab7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Value() : ViewModel() {
    var x = MutableLiveData<String>()
}
