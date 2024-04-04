package com.example.newsapp.save_entry

import kotlinx.coroutines.flow.Flow

interface localmanger {

    suspend fun saveentry()

    fun readentry(): Flow<Boolean>
}
