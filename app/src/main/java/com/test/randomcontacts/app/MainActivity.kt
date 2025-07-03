package com.test.randomcontacts.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.test.randomcontacts.contactDetails.logic.ContactDetailsViewModel
import com.test.randomcontacts.contactsList.logic.ContactsListViewModel
import com.test.randomcontacts.shared.ContactDetailsViewModelFactory
import com.test.randomcontacts.shared.ContactsListViewModelFactory
import com.test.randomcontacts.shared.theme.RandomContactsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val contactsListViewModel: ContactsListViewModel by lazy {
        ContactsListViewModelFactory(this.application).create(ContactsListViewModel::class.java)
    }
    val contactDetailsViewModel: ContactDetailsViewModel by lazy {
        ContactDetailsViewModelFactory(this.application).create(ContactDetailsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomContactsTheme {
                val snackState = SnackbarHostState()
                val scope = rememberCoroutineScope()
                Scaffold(modifier = Modifier.fillMaxSize(), snackbarHost = {
                    SnackbarHost(snackState) {
                        Snackbar(it)
                    }
                }) { innerPadding ->
                    NavigationMain(innerPadding, contactsListViewModel, contactDetailsViewModel) {
                        scope.launch {
                            snackState.showSnackbar(it)
                        }
                    }
                }
            }
        }
    }
}