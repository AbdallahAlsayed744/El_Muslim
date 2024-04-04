package com.example.newsapp.save_entry

import kotlinx.coroutines.flow.Flow


class readentry(
    private val localmanager: localmanger
) {

    operator fun invoke(): Flow<Boolean> {
        return localmanager.readentry()
    }
}