package com.videumcorp.kotlinlifecycleexample.model

import java.util.*

class ApiService {
    // Simulation we update our data from an API
    companion object {
        fun fetchUserFromAPI(userName: String): UserModel {
            return UserModel(userName, Random().nextInt(100 - 0))
        }
    }
}