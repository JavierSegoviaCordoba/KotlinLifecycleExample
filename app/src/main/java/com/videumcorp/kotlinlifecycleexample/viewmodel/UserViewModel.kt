package com.videumcorp.kotlinlifecycleexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.videumcorp.kotlinlifecycleexample.model.ApiService
import com.videumcorp.kotlinlifecycleexample.model.UserModel

class UserViewModel : ViewModel() {
    var userModel = UserModel("Default", 0)
    var name = MutableLiveData<String>()
    var age = MutableLiveData<Int>()

    // Show default data
    init {
        name.postValue(userModel.name)
        age.postValue(userModel.age)
    }

    // Get userName from MainActivity editText and pass it to the model service
    fun readUserFromEditText(userName: String) {
        userModel = ApiService.fetchUserFromAPI(userName)
        name.postValue(userModel.name)
        age.postValue(userModel.age)
    }
}