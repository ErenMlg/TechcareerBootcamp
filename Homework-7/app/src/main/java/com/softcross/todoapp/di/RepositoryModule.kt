package com.softcross.todoapp.di

import com.softcross.todoapp.data.repository.ToDosRepositoryImpl
import com.softcross.todoapp.domain.repository.ToDosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTodoRepository(todoRepositoryImpl: ToDosRepositoryImpl): ToDosRepository

}