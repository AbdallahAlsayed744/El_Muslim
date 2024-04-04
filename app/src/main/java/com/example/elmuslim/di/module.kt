package com.example.elmuslim.di

import android.app.Application
import com.example.elmuslim.datasources.remote.Api
import com.example.elmuslim.datasources.remote.Api_Ahadis
import com.example.elmuslim.datasources.remote.Api_lesinting
import com.example.newsapp.save_entry.localmanager
import com.example.newsapp.save_entry.localmanger
import com.example.newsapp.save_entry.myappsaveorread
import com.example.newsapp.save_entry.readentry
import com.example.newsapp.save_entry.saveentry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object module {

    @Provides
    @Singleton
    fun providelocalmanger(app: Application): localmanger {
        return localmanager(app)
    }

    @Provides
    @Singleton
    fun providesaveorreaddata(localmanager: localmanger): myappsaveorread {
        return myappsaveorread(saveentry(localmanager), readentry(localmanager))
    }

    @Provides
    @Singleton
    fun provideretrofit():Api{
        return Retrofit.Builder().baseUrl("https://alquran.vip/APIs/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideretrofit2():Api_Ahadis{
        return Retrofit.Builder().baseUrl("https://api.hadith.gading.dev/books/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api_Ahadis::class.java)
    }

    @Provides
    @Singleton
    fun provideretrofit3():Api_lesinting{
        return Retrofit.Builder().baseUrl("https://mp3quran.net/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api_lesinting::class.java)
    }


}