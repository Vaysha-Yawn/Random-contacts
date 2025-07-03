package com.test.randomcontacts.contactDetails.logic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.test.randomcontacts.data.room.LoadByIdRoomUseCase
import com.test.randomcontacts.app.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as App
    private val loadByIdUseCase = LoadByIdRoomUseCase(app.roomDao)

    private val _state = MutableStateFlow<ContactDetailsState>(ContactDetailsState.Loading)
    val state = _state.asStateFlow()

    fun load(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = ContactDetailsState.Loading
            val result = loadByIdUseCase.loadById(id)
            when (result) {
                null -> _state.value = ContactDetailsState.Error("ContactNotFound")
                else -> _state.value = ContactDetailsState.Success(result)
            }
        }

    }
}