package com.test.randomcontacts.data

sealed interface ContactResponseResult {
    data class Success(val list: List<ContactData>) : ContactResponseResult
    data class Error(val message: String) : ContactResponseResult
}