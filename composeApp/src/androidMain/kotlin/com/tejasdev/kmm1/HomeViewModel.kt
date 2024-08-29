package com.tejasdev.kmm1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tejasdev.kmm1.api.Repository
import com.tejasdev.kmm1.data.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val _users = MutableStateFlow<List<Result>>(emptyList())
    val users get() = _users.asStateFlow()

    private val homeRepository: Repository = Repository()

    init {
        viewModelScope.launch {
            homeRepository.getUsers().collect {users ->
                _users.update {
                    it + users
                }
            }
        }
    }

}