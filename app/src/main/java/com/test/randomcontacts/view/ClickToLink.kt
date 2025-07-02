package com.test.randomcontacts.view

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import com.test.randomcontacts.R

fun callEmail(data: String, context: Context, onError: (String) -> Unit) {
    var callIntent = Intent(Intent.ACTION_VIEW, "mailto:$data".toUri())
    startIntent(callIntent, context, onError)
}

fun callPhone(
    data: String,
    context: Context,
    onError: (String) -> Unit,
) {
    val phoneIntent = Intent(Intent.ACTION_VIEW, "tel:$data".toUri())
    startIntent(phoneIntent, context, onError)
}

fun callAddress(latitude: String, longitude: String, context: Context, onError: (String) -> Unit) {
    val mapIntent = Intent(Intent.ACTION_VIEW, "geo:$latitude,$longitude".toUri())
    startIntent(mapIntent, context, onError)
}

fun startIntent(intent: Intent, context: Context, onError: (String) -> Unit) {
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        onError(e.message ?: context.getString(R.string.app_not_found))
    }
}