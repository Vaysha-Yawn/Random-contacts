package com.test.randomcontacts.app

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.test.randomcontacts.contactDetails.logic.ContactDetailsViewModel
import com.test.randomcontacts.contactDetails.view.ContactDetails
import com.test.randomcontacts.contactDetails.navigation.ContactDetailsDestination
import com.test.randomcontacts.contactsList.logic.ContactsListViewModel
import com.test.randomcontacts.contactsList.view.ContactsList
import com.test.randomcontacts.contactsList.navigation.ContactsListDestination


@Composable
fun NavigationMain(
    innerPadding: PaddingValues,
    contactsListViewModel: ContactsListViewModel,
    contactDetailsViewModel: ContactDetailsViewModel,
    onError: (String) -> Unit
) {
    val nav = rememberNavController()
    NavHost(
        navController = nav,
        startDestination = ContactsListDestination,
        modifier = Modifier.padding(innerPadding),
        enterTransition = {
            slideInHorizontally(
                animationSpec = tween(700),
                initialOffsetX = { fullWidth -> fullWidth }
            ) + fadeIn(tween(700))
        },
        exitTransition = {
            fadeOut(tween(700))
        },
        popExitTransition = {
            slideOutHorizontally(
                animationSpec = tween(700),
                targetOffsetX = { fullWidth -> fullWidth }
            ) +
                    fadeOut(tween(700))
        },
        popEnterTransition = {
            fadeIn(tween(700))
        }) {
        composable<ContactsListDestination> {
            ContactsList(contactsListViewModel, onError = onError, nav = nav)
        }
        composable<ContactDetailsDestination> {
            val id = it.toRoute<ContactDetailsDestination>().id
            ContactDetails(contactDetailsViewModel, onError = onError, id = id)
        }
    }
}