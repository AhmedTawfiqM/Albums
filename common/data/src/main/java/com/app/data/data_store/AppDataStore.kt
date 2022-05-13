package com.app.data.data_store

import android.content.Context
import kotlinx.coroutines.flow.Flow

/**
 * example
 */
class AppDataStore(
    context: Context,
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