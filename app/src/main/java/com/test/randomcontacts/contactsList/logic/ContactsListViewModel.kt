package com.test.randomcontacts.contactsList.logic

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.test.randomcontacts.data.ContactResponseResult
import com.test.randomcontacts.data.repository.ILoadContactsRepository
import com.test.randomcontacts.data.repository.LoadContactsRepository
import com.test.randomcontacts.app.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactsListViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as App
    private val loadPageUseCase =
        LoadContactsRepository(app.contactRetrofitDao, app.roomDao) as ILoadContactsRepository

    private val _state = MutableStateFlow<ContactsListState>(ContactsListState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = ContactsListState.Loading
            val result = loadPageUseCase.loadContacts()
            when (result) {
                is ContactResponseResult.Error -> _state.value =
                    ContactsListState.Error(result.message)

                is ContactResponseResult.Success -> _state.value =
                    ContactsListState.Success(result.list)
            }
        }
    }

    fun updateLoadContacts() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = ContactsListState.Loading
            val result = loadPageUseCase.updateLoad()
            when (result) {
                is ContactResponseResult.Error -> _state.value =
                    ContactsListState.Error(result.message)

                is ContactResponseResult.Success -> _state.value =
                    ContactsListState.Success(result.list)
            }
        }
    }
}