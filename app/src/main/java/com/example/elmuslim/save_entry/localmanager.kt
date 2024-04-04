package com.example.newsapp.save_entry

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.elmuslim.utilis.constants.PREF_NAME
import com.example.elmuslim.utilis.constants.key
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class localmanager(
    private val context: Context
):localmanger {
    override suspend fun saveentry() {
        context.datastore.edit {
                setting->
            setting[prefrenceskeys.app_key]=true
        }

    }

    override  fun readentry(): Flow<Boolean> {
        return context.datastore.data.map {
                pref->
            pref[prefrenceskeys.app_key]?:false
        }
    }



}
private val Context.datastore : DataStore<Preferences> by preferencesDataStore(name =PREF_NAME )

private object prefrenceskeys{
    val app_key= booleanPreferencesKey(name = key)
}
