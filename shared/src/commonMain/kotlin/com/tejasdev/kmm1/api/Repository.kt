package com.tejasdev.kmm1.api

import com.tejasdev.kmm1.data.RandomUserResult
import com.tejasdev.kmm1.data.Result
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class Repository {

    private val BASE_URL = "https://randomuser.me/api?page=1&results=40&seed=abc"
    suspend fun getRandomUsers(): RandomUserResult{
        val response = httpClient.get(BASE_URL)
        return response.body()
    }

    fun getUsers() = flow {
        emit(getRandomUsers().results)
    }

    suspend fun getUsersWithoutFlow(): List<Result> {
        return getRandomUsers().results
    }
}