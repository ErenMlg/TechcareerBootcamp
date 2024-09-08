package com.softcross.todoapp.di

import android.content.Context
import androidx.room.Room
import com.softcross.todoapp.data.local.dao.ToDosDao
import com.softcross.todoapp.data.local.database.Database
import com.softcross.todoapp.data.source.LocalDataSource
import com.softcross.todoapp.data.source.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object LocalModule {

    @Provides
    @ViewModelScoped
    fun provideLocalDataSource(@ApplicationContext context: Context): ToDosDao {
        return Room.databaseBuilder(context, Database::class.java, "todo.sqlite")
            .createFromAsset("todo.sqlite").build().getToDosDao()
    }

}