package com.app.data.data_store

import android.content.Context
import kotlinx.coroutines.flow.Flow

/**
 * Created by Ahmed Tawfik at 14/5/2022
 * /
 * example of using 'BaseDataStore'
 */
class AppDataStore(
    context: Context, //TODO: set global app context as default
    name: String = "default_preferences"
) : BaseDataStore(context, name) {

    suspend fun saveName(value: String) {
        save(DataStoreType.Name, value)
    }

    suspend fun getName(): String? {
        return get(DataStoreType.Name)
    }

    suspend fun getFlowName(): Flow<String?> {
        return getFlow(DataStoreType.Name)
    }
}

enum class DataStoreType(override var key: String) : StoreKey {
    Name("name"),
}