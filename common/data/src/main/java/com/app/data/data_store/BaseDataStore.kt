package com.app.data.data_store

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.*

/**
 * Created by Ahmed Tawfik at 14/5/2022
 * /
 * this Class contains complete reusable Apis of Data Store.
 * App Client will inherit and do its related Stuff :)
 */
open class BaseDataStore(context: Context, name: String) {
    val dataStore by lazy { context.createDataStore(name) }
    private val tag = this::class.simpleName

    suspend inline fun <reified T : Any> save(key: StoreKey, value: T) {
        val preferencesKey = preferencesKey<T>(key.key)
        dataStore.edit {
            it[preferencesKey] = value
        }
    }

    suspend inline fun <reified T : Any> get(key: StoreKey): T? {
        val preferencesKey = preferencesKey<T>(key.key)
        val data = dataStore.data.catch { ex ->
            onReadingException(flow = this, ex = ex)
        }.first()
        return data[preferencesKey]
    }

    suspend inline fun <reified T : Any> getFlow(key: StoreKey): Flow<T?> {
        return dataStore.data
            .catch { exception ->
                onReadingException(flow = this, ex = exception)
            }
            .map { preference ->
                val preferencesKey = preferencesKey<T>(key.key)
                val value = preference[preferencesKey]
                value
            }
    }

    suspend fun onReadingException(
        flow: FlowCollector<Preferences>,
        ex: Throwable,
    ) {
        Log.d(tag, "exception: ${ex.message}")
        flow.emit(emptyPreferences())
    }
}